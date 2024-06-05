package com.sararf.hotel.booking.module.hotel.service;

import com.sararf.hotel.booking.module.hotel.entity.RoomEntity;

import java.util.Date;
import java.util.List;

public interface RoomService {
	RoomEntity findRoomById(Long roomId);
	List<RoomEntity> findHotelRoomsByIds(Long hotelId, List<Long> roomIds);
	List<RoomEntity> getHotelAvailableRoomDetails(Long hotelId, Date checkInDate, Date checkOutDate);
}
