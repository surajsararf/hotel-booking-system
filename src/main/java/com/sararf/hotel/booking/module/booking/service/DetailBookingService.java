package com.sararf.hotel.booking.module.booking.service;


import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.booking.dto.BookingResponseDTO;

import java.util.List;

public interface DetailBookingService {
	BookingResponseDTO bookingDetail(Long bookingId, UserEntity user);

	List<BookingResponseDTO> bookingList(UserEntity user);
}
