package com.sararf.hotel.booking.module.hotel.service.impl;

import com.sararf.hotel.booking.exception.EntityNotFoundException;
import com.sararf.hotel.booking.module.hotel.dao.AmenitiesRepository;
import com.sararf.hotel.booking.module.hotel.dao.HotelRepository;
import com.sararf.hotel.booking.module.hotel.dao.ImageRepository;
import com.sararf.hotel.booking.module.hotel.dao.RoomRepository;
import com.sararf.hotel.booking.module.hotel.dto.HotelDTO;
import com.sararf.hotel.booking.module.hotel.entity.HotelEntity;
import com.sararf.hotel.booking.module.hotel.entity.ImagesEntity;
import com.sararf.hotel.booking.module.hotel.entity.RoomEntity;
import com.sararf.hotel.booking.module.hotel.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("hotelService")
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService, RoomService, ImageService, AmenitiesService {
	private final HotelRepository hotelRepository;
	private final RoomRepository roomRepository;
	private final ImageRepository imageRepository;
	private final AmenitiesRepository amenitiesRepository;

	@Override
	public HotelEntity findHotelById(Long hotelId) {
		log.info("Finding hotel by id {}", hotelId);
		return hotelRepository
				.findById(hotelId)
				.orElseThrow(() -> new EntityNotFoundException("Hotel not found", HttpStatus.NOT_FOUND));
	}

	@Override
	public List<HotelDTO> searchHotelByLocationAndLatLngAndCapacityAndNumberOfRoomsAndCheckInOutDate(String location, double lat, double lan, int capacity, int numberOfRooms, Date checkInDate, Date checkOutDate) {
		log.info("Searching hotel by location {} or lat {} and lan {} and capacity {} and checkInDate {} and checkOutDate {} and numberOfRooms {}", location, lat, lan, capacity, checkInDate, checkOutDate, numberOfRooms);
		return hotelRepository.fetchByLocationOrLatLng(location, lat, lan, capacity, checkInDate, checkOutDate, numberOfRooms);
	}

	@Override
	public RoomEntity findRoomById(Long roomId) {
		log.info("Finding room by id {}", roomId);
		return roomRepository
				.findById(roomId)
				.orElseThrow(() -> new EntityNotFoundException("Room not found", HttpStatus.NOT_FOUND));
	}

	@Override
	public List<RoomEntity> findHotelRoomsByIds(Long hotelId, List<Long> roomIds) {
		log.info("Finding rooms by hotel id {} and room ids {}", hotelId, roomIds);
		return roomRepository.findByHotelEntityIdAndIdIn(hotelId, roomIds)
				.orElseThrow(() -> new EntityNotFoundException("Rooms not found", HttpStatus.NOT_FOUND));
	}


	@Override
	public List<RoomEntity> getHotelAvailableRoomDetails(Long hotelId, Date checkInDate, Date checkOutDate) {
		log.info("Getting hotel details by hotel id {}", hotelId);
		return roomRepository.findByHotelEntityId(hotelId, checkInDate, checkOutDate).orElse(null);
	}

	@Override
	public List<ImagesEntity> findImagesByHotelId(Long hotelId) {
		return imageRepository.findByHotelEntityId(hotelId);
	}

	@Override
	public List<ImagesEntity> findImagesByRoomId(Long roomId) {
		return imageRepository.findByRoomEntityId(roomId);
	}

	@Override
	public List<String> findByHotelId(Long hotelId) {
		return amenitiesRepository.findAmenitiesByHotelId(hotelId);
	}

	@Override
	public List<String> findByRoomId(Long roomId) {
		return amenitiesRepository.findAmenitiesByRoomId(roomId);
	}
}
