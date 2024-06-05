package com.sararf.hotel.booking.module.hotel.service.impl;

import com.sararf.hotel.booking.exception.ValidationFailedException;
import com.sararf.hotel.booking.module.hotel.dto.*;
import com.sararf.hotel.booking.module.hotel.entity.HotelEntity;
import com.sararf.hotel.booking.module.hotel.entity.ImagesEntity;
import com.sararf.hotel.booking.module.hotel.entity.RoomEntity;
import com.sararf.hotel.booking.module.hotel.service.*;
import com.sararf.hotel.booking.utils.BookingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
		validation(capacity, numberOfRooms, checkInDate, checkOutDate);
		List<HotelDTO> hotelDTOList = hotelService.searchHotelByLocationAndLatLngAndCapacityAndNumberOfRoomsAndCheckInOutDate(location, lat, lan, capacity / numberOfRooms, numberOfRooms, checkInDate, checkOutDate);
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

	private void validation(int capacity, int numberOfRooms, Date checkInDate, Date checkOutDate) {
		log.info("Validating capacity {} and number of rooms {} and check in date {} and check out date {}",
				capacity, numberOfRooms, checkInDate, checkOutDate);
		List<String> error = new ArrayList<>();
		if (capacity == 0) {
			error.add("Capacity can not be null or Zero");
		}
		if (numberOfRooms == 0) {
			error.add("Number of rooms can not be null or Zero");
		}
		if (checkInDate == null) {
			error.add("Check in date can not be null");
		}
		if (checkOutDate == null) {
			error.add("Check out date can not be null");
		}
		if (!Objects.isNull(checkInDate) && !Objects.isNull(checkOutDate)
				&& !(checkOutDate.after(checkInDate)
				&& checkInDate.after(new Date()))) {
			error.add("Check out date can not be before check in date and check in date can not be before current date");
		}
		if (!error.isEmpty()) {
			log.error("Validation failed {}", error);
			throw new ValidationFailedException("Value are not valid ", HttpStatus.BAD_REQUEST, error);
		}
	}

	@Override
	public HotelDetailsDTO getHotelDetails(Long hotelId, Date checkInDate, Date checkOutDate) {
		log.info("Getting hotel details by hotel id {}", hotelId);
		validation(10, 10, checkInDate, checkOutDate);
		HotelEntity hotelEntity = hotelService.findHotelById(hotelId);
		List<RoomEntity> roomEntityList = roomService.getHotelAvailableRoomDetails(hotelId, checkInDate, checkOutDate);
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
