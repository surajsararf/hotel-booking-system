package com.sararf.hotel.booking.module.booking.service.impl;

import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.booking.dto.BookingResponseDTO;
import com.sararf.hotel.booking.module.booking.entity.BookingEntity;
import com.sararf.hotel.booking.module.booking.enums.BookingEnum;
import com.sararf.hotel.booking.module.booking.service.BookingService;
import com.sararf.hotel.booking.module.booking.service.CancelBookingService;
import com.sararf.hotel.booking.module.booking.service.PaymentService;
import com.sararf.hotel.booking.module.hotel.service.HotelService;
import com.sararf.hotel.booking.module.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CancelBookingServiceImpl implements CancelBookingService {
	private final BookingService bookingService;
	private final PaymentService paymentService;
	private final HotelService hotelService;
	private final RoomService roomService;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public BookingResponseDTO cancelBooking(Long bookingEntityID, UserEntity user) {
		log.info("Cancelling booking {}", bookingEntityID);
		bookingService.findBookingByIdAndUserId(bookingEntityID, user.getId());
		BookingEntity bookingEntity = bookingService.cancelBooking(bookingEntityID, BookingEnum.BookingStatus.CANCELLED.name());
		paymentService.cancelPayment(bookingEntity.getPaymentId(), BookingEnum.BookingStatus.CANCELLED.name());
		return BookingResponseDTO.builder()
				.bookingId(bookingEntity.getId())
				.orderId(bookingEntity.getOrderId())
				.bookingAmount(bookingEntity.getBookingAmount())
				.hotelName(bookingEntity.getHotelEntity().getName())
				.bookingStatus(BookingEnum.BookingStatus.CANCELLED.name())
				.build();
	}
}
