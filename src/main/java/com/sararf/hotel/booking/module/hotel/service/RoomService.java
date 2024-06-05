package com.sararf.hotel.booking.module.hotel.service;

import com.sararf.hotel.booking.module.booking.dto.RoomRequestDTO;
import com.sararf.hotel.booking.module.hotel.entity.RoomEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoomService {
	RoomEntity findRoomById(Long roomId);
	List<RoomEntity> findHotelRoomsByIds(Long hotelId, List<Long> roomIds);
	List<RoomEntity> getHotelDetails(Long hotelId, Date checkInDate, Date checkOutDate);
}
