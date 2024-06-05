package com.sararf.hotel.booking.module.hotel.service;

import com.sararf.hotel.booking.module.hotel.dto.AmenitiesDTO;

import java.util.List;

public interface AmenitiesService {
	List<String> findByHotelId(Long hotelId);
	List<String> findByRoomId(Long roomId);
}
