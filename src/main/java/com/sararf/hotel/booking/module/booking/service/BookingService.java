package com.sararf.hotel.booking.module.booking.service;

import com.sararf.hotel.booking.module.booking.entity.BookingEntity;
import com.sararf.hotel.booking.module.booking.entity.BookingRoomMapping;

import java.util.List;

public interface BookingService {
	BookingEntity createBooking(BookingEntity bookingEntity);
	List<BookingRoomMapping> createBookingRoomMapping(List<BookingRoomMapping> bookingRoomMappingList);
	BookingEntity findBookingById(Long bookingId);
	BookingEntity findBookingByIdAndUserId(Long bookingId, Long usrId);
	List<BookingEntity> findUserId(Long userId);
	BookingEntity cancelBooking(Long bookingId, String status);
	List<BookingRoomMapping> findBookingRoomMapping(Long bookingId);
}
