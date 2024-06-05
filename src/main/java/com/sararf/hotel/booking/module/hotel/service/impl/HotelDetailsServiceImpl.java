package com.sararf.hotel.booking.module.hotel.service.impl;

import com.sararf.hotel.booking.module.hotel.dto.*;
import com.sararf.hotel.booking.module.hotel.entity.HotelEntity;
import com.sararf.hotel.booking.module.hotel.entity.ImagesEntity;
import com.sararf.hotel.booking.module.hotel.entity.RoomEntity;
import com.sararf.hotel.booking.module.hotel.service.*;
import com.sararf.hotel.booking.utils.BookingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelDetailsServiceImpl implements HotelDetailsService {
	private final HotelService hotelService;
	private final RoomService roomService;
	private final ImageService imageService;
	private final AmenitiesService amenitiesService;

	@Override
	public List<HotelDTO> listOfHotelDTO(String location, double lat, double lan, int capacity, int numberOfRooms, Date checkInDate, Date checkOutDate) {
		log.info("Searching hotel by location {} or lat {} and lan {} and capacity {} and checkInDate {} and checkOutDate {} and numberOfRooms {}",
				location, lat, lan, capacity, checkInDate, checkOutDate, numberOfRooms);
		List<HotelDTO> hotelDTOList = hotelService.searchHotelByLocationAndLatLngAndCapacityAndNumberOfRoomsAndCheckInOutDate(location, lat, lan, capacity, numberOfRooms, checkInDate, checkOutDate);
		for (HotelDTO hotelDTO : hotelDTOList) {
			log.info("Finding images and amenities by hotel id {}", hotelDTO.getId());
			List<ImagesEntity> imagesEntityList = imageService.findImagesByHotelId(hotelDTO.getId());
			List<String> amenitiesDTOSList = amenitiesService.findByHotelId(hotelDTO.getId());

			hotelDTO.setImages(imagesEntityList.stream()
					.map(s -> ImageDTO.builder().imageUrl(s.getImageUrl()).imageType(s.getImageType()).build())
					.toList());
			hotelDTO.setAmenities(amenitiesDTOSList);
		}
		return hotelDTOList;
	}

	@Override
	public HotelDetailsDTO getHotelDetails(Long hotelId, Date checkInDate, Date checkOutDate) {
		log.info("Getting hotel details by hotel id {}", hotelId);

		HotelEntity hotelEntity = hotelService.findHotelById(hotelId);
		List<RoomEntity> roomEntityList = roomService.getHotelDetails(hotelId, checkInDate, checkOutDate);
		HotelDetailsDTO hotelDetailsDTO = BookingUtils.toHotelDetailsDTO(hotelEntity, roomEntityList);

		for (RoomDetailsDTO roomDetailsDTO : hotelDetailsDTO.getRooms()) {
			log.info("Finding images by room id {}", roomDetailsDTO.getId());
			List<ImagesEntity> imagesEntityList = imageService.findImagesByRoomId(roomDetailsDTO.getId());
			List<String> amenitiesDTOList = amenitiesService.findByRoomId(roomDetailsDTO.getId());
			roomDetailsDTO.setAmenities(amenitiesDTOList);
			roomDetailsDTO.setImages(imagesEntityList.stream()
					.map(s -> ImageDTO.builder()
							.imageUrl(s.getImageUrl())
							.imageType(s.getImageType())
							.build())
					.toList());
		}
		return hotelDetailsDTO;
	}
}
