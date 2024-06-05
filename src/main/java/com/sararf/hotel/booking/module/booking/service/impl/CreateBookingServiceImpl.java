package com.sararf.hotel.booking.module.booking.service.impl;

import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.exception.ValidationFailedException;
import com.sararf.hotel.booking.module.booking.dto.BookingRequestDTO;
import com.sararf.hotel.booking.module.booking.dto.BookingResponseDTO;
import com.sararf.hotel.booking.module.booking.dto.RoomRequestDTO;
import com.sararf.hotel.booking.module.booking.entity.BookingEntity;
import com.sararf.hotel.booking.module.booking.entity.BookingRoomMapping;
import com.sararf.hotel.booking.module.booking.entity.PaymentEntity;
import com.sararf.hotel.booking.module.booking.service.BookingService;
import com.sararf.hotel.booking.module.booking.service.CreateBookingService;
import com.sararf.hotel.booking.module.booking.service.PaymentService;
import com.sararf.hotel.booking.module.hotel.entity.HotelEntity;
import com.sararf.hotel.booking.module.hotel.entity.RoomEntity;
import com.sararf.hotel.booking.module.hotel.service.HotelService;
import com.sararf.hotel.booking.module.hotel.service.RoomService;
import com.sararf.hotel.booking.utils.BookingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("createBookingService")
@Slf4j
public class CreateBookingServiceImpl implements CreateBookingService {

	private final BookingService bookingService;
	private final PaymentService paymentService;
	private final HotelService hotelService;
	private final RoomService roomService;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO, UserEntity userEntity) {
		log.info("Creating booking {}", bookingRequestDTO);
		HotelEntity hotelEntity = hotelService.findHotelById(bookingRequestDTO.getHotelId());
		List<RoomEntity> roomEntityList = roomService
				.findHotelRoomsByIds(bookingRequestDTO.getHotelId(),
						bookingRequestDTO
								.getRoomRequestList()
								.stream()
								.map(RoomRequestDTO::getRoomId)
								.collect(Collectors.toList()));
		double amount = BookingUtils.calculateBookingAmount(roomEntityList, bookingRequestDTO);
		log.info("total amount calculated {}", amount);
		validation(bookingRequestDTO);

		PaymentEntity paymentEntity = paymentService.createPayment(amount);
		log.info("payment created {}, order id {}", paymentEntity.getId(), paymentEntity.getOrderId());
		BookingEntity bookingEntity = bookingService.createBooking(BookingUtils
				.toBookingEntity(bookingRequestDTO, paymentEntity,
						userEntity, hotelEntity, amount));
		log.info("booking created {}", bookingEntity.getId());
		List<BookingRoomMapping> bookingRoomMapping = bookingService
				.createBookingRoomMapping(BookingUtils
						.toBookingRoomMapping(bookingRequestDTO,
								bookingEntity, roomEntityList));

		return BookingUtils.toBookingResponseDTO(bookingEntity, bookingRoomMapping);
	}

	private void validation(BookingRequestDTO bookingRequestDTO) {
		log.info("Validating booking request {}", bookingRequestDTO);
		List<RoomEntity> roomList = roomService.getHotelAvailableRoomDetails(bookingRequestDTO.getHotelId(),
				bookingRequestDTO.getCheckInDate(), bookingRequestDTO.getCheckOutDate());

		bookingRequestDTO.getRoomRequestList()
				.forEach(s -> {
					if (roomList.stream().noneMatch(roomEntity ->
							roomEntity.getId().equals(s.getRoomId())
									&& roomEntity.getTotalRooms() >= s.getNumberOfRooms())) {
						log.error("room id {} not available", s.getRoomId());
						throw new ValidationFailedException("Room not available", HttpStatus.BAD_REQUEST);
					}
				});
	}
}
