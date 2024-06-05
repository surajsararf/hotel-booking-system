package com.sararf.hotel.booking.module.hotel.service;

import com.sararf.hotel.booking.module.hotel.entity.ImagesEntity;

import java.util.List;

public interface ImageService {
	List<ImagesEntity> findImagesByHotelId(Long hotelId);
	List<ImagesEntity> findImagesByRoomId(Long roomId);
}
