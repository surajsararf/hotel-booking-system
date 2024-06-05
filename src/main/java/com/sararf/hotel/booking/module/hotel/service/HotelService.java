package com.sararf.hotel.booking.module.hotel.service;

import com.sararf.hotel.booking.module.hotel.dto.HotelDTO;
import com.sararf.hotel.booking.module.hotel.entity.HotelEntity;

import java.util.Date;
import java.util.List;

public interface HotelService {
	HotelEntity findHotelById(Long hotelId);
	List<HotelDTO> searchHotelByLocationAndLatLngAndCapacityAndNumberOfRoomsAndCheckInOutDate(String location, double lat, double lan, int capacity, int numberOfRooms, Date checkInDate, Date checkOutDate);
}
