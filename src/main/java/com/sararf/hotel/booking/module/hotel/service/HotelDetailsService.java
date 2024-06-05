package com.sararf.hotel.booking.module.hotel.service;


import com.sararf.hotel.booking.module.hotel.dto.HotelDTO;
import com.sararf.hotel.booking.module.hotel.dto.HotelDetailsDTO;

import java.util.Date;
import java.util.List;

public interface HotelDetailsService {
	List<HotelDTO> listOfHotelDTO(String location, double lat, double lan, int capacity, int numberOfRooms, Date checkInDate, Date checkOutDate);
	HotelDetailsDTO getHotelDetails(Long hotelId, Date checkInDate, Date checkOutDate);
}
