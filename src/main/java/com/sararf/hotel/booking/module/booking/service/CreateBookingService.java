package com.sararf.hotel.booking.module.booking.service;

import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.booking.dto.BookingRequestDTO;
import com.sararf.hotel.booking.module.booking.dto.BookingResponseDTO;

public interface CreateBookingService {
	BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO, UserEntity userEntity);
}
