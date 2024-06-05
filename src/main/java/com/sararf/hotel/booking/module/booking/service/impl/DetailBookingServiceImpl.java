package com.sararf.hotel.booking.module.booking.service.impl;

import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.booking.dto.BookingResponseDTO;
import com.sararf.hotel.booking.module.booking.entity.BookingEntity;
import com.sararf.hotel.booking.module.booking.entity.BookingRoomMapping;
import com.sararf.hotel.booking.module.booking.service.BookingService;
import com.sararf.hotel.booking.module.booking.service.DetailBookingService;
import com.sararf.hotel.booking.module.booking.service.PaymentService;
import com.sararf.hotel.booking.utils.BookingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DetailBookingServiceImpl implements DetailBookingService {
	private final BookingService bookingService;

	@Override
	public BookingResponseDTO bookingDetail(Long bookingId, UserEntity user) {
		log.info("Getting booking detail for booking id {}", bookingId);
		BookingEntity bookingEntity = bookingService.findBookingByIdAndUserId(bookingId, user.getId());
		List<BookingRoomMapping> bookingRoomMappingList = bookingService.findBookingRoomMapping(bookingId);
		return BookingUtils.toBookingResponseDTO(bookingEntity, bookingRoomMappingList);
	}

	@Override
	public List<BookingResponseDTO> bookingList(UserEntity user) {
		log.info("Getting booking list for user {}", user.getId());
		List<BookingEntity> bookingEntities = bookingService.findUserId(user.getId());
		List<BookingResponseDTO> bookingResponseDTOS = new ArrayList<>();
		for (BookingEntity bookingEntity : bookingEntities) {
			bookingResponseDTOS.add(BookingUtils.toBookingResponseDTO(bookingEntity));
		}
		return bookingResponseDTOS;
	}
}
