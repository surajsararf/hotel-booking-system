package com.sararf.hotel.booking.module.booking.service;

import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.booking.dto.BookingResponseDTO;
import com.sararf.hotel.booking.module.booking.entity.BookingEntity;

public interface CancelBookingService {
	BookingResponseDTO cancelBooking(Long bookingEntityID, UserEntity user);
}
