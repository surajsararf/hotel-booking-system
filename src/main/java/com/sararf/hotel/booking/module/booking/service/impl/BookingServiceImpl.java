package com.sararf.hotel.booking.module.booking.service.impl;

import com.sararf.hotel.booking.exception.EntityNotFoundException;
import com.sararf.hotel.booking.exception.ValidationFailedException;
import com.sararf.hotel.booking.module.booking.dao.BookingRepository;
import com.sararf.hotel.booking.module.booking.dao.BookingRoomMappingRepository;
import com.sararf.hotel.booking.module.booking.dao.PaymentRepository;
import com.sararf.hotel.booking.module.booking.entity.BookingEntity;
import com.sararf.hotel.booking.module.booking.entity.BookingRoomMapping;
import com.sararf.hotel.booking.module.booking.entity.PaymentEntity;
import com.sararf.hotel.booking.module.booking.enums.BookingEnum;
import com.sararf.hotel.booking.module.booking.service.BookingService;
import com.sararf.hotel.booking.module.booking.service.PaymentService;
import com.sararf.hotel.booking.utils.BookingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService, PaymentService {
	private final BookingRepository bookingRepository;
	private final BookingRoomMappingRepository bookingRoomMappingRepository;
	private final PaymentRepository paymentRepository;

	@Override
	public PaymentEntity createPayment(Double amount) {
		log.info("Creating payment for amount {}", amount);
		PaymentEntity paymentEntity = savePayment(BookingUtils.payments(amount));
		paymentEntity.setOrderId(BookingUtils.getOrderId(paymentEntity.getId()));
		return savePayment(paymentEntity);
	}

	@Override
	public PaymentEntity savePayment(PaymentEntity paymentEntity) {
		log.info("Saving payment {}", paymentEntity);
		return paymentRepository.saveAndFlush(paymentEntity);
	}

	@Override
	public BookingEntity createBooking(BookingEntity bookingEntity) {
		log.info("Creating booking {}", bookingEntity);
		return bookingRepository.saveAndFlush(bookingEntity);
	}

	@Override
	public List<BookingRoomMapping> createBookingRoomMapping(List<BookingRoomMapping> bookingRoomMappingList) {
		log.info("Creating booking room mapping {}", bookingRoomMappingList);
		return bookingRoomMappingRepository.saveAll(bookingRoomMappingList);
	}

	@Override
	public BookingEntity findBookingById(Long bookingId) {
		log.info("Finding booking by id {}", bookingId);
		return bookingRepository
				.findById(bookingId)
				.orElseThrow(() -> new EntityNotFoundException("Booking not found", HttpStatus.NOT_FOUND));
	}

	@Override
	public BookingEntity findBookingByIdAndUserId(Long bookingId, Long usrId) {
		log.info("Finding booking by id {} and user id {}", bookingId, usrId);
		return bookingRepository.findByIdAndUserId(bookingId, usrId)
				.orElseThrow(() -> new EntityNotFoundException("Booking not found", HttpStatus.NOT_FOUND));
	}

	@Override
	public List<BookingEntity> findUserId(Long userId) {
		log.info("Finding booking by user id {}", userId);
		return bookingRepository.findByUserId(userId)
				.orElseThrow(() -> new EntityNotFoundException("Booking not found", HttpStatus.NOT_FOUND));
	}

	@Override
	public PaymentEntity cancelPayment(Long paymentId, String status) {
		log.info("Cancelling payment for payment id {} with status {}", paymentId, status);
		PaymentEntity paymentEntity = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new EntityNotFoundException("Payment not found", HttpStatus.NOT_FOUND));
		paymentEntity.setPaymentStatus(BookingEnum.PaymentStatus.CANCELLED.name());
		return paymentRepository.saveAndFlush(paymentEntity);
	}

	@Override
	public PaymentEntity findById(Long paymentId) {
		log.info("Finding payment by id {}", paymentId);
		return paymentRepository.findById(paymentId)
				.orElseThrow(() -> new EntityNotFoundException("Payment not found", HttpStatus.NOT_FOUND));
	}

	@Override
	@Transactional
	public BookingEntity cancelBooking(Long bookingId, String status) {
		log.info("Updating booking status for booking id {} to {}", bookingId, status);
		BookingEntity bookingEntity = bookingRepository.findForCancelEntity(bookingId, status);
		if (Objects.isNull(bookingEntity)) {
			throw new ValidationFailedException("Booking can not be Cancelled cause of already cancelled or user check in",
					HttpStatus.NOT_FOUND);
		}
		bookingEntity.setBookingStatus(status);
		return bookingRepository.saveAndFlush(bookingEntity);
	}

	@Override
	public List<BookingRoomMapping> findBookingRoomMapping(Long bookingId) {
		log.info("Finding booking room mapping for booking id {}", bookingId);
		return bookingRoomMappingRepository.findByBookingEntityId(bookingId)
				.orElseThrow(() -> new EntityNotFoundException("Booking room mapping not found", HttpStatus.NOT_FOUND));
	}
}
