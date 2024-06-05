package com.sararf.hotel.booking.module.hotel.controller;

import com.sararf.hotel.booking.common.ResponseWrapperDTO;
import com.sararf.hotel.booking.module.hotel.dto.HotelDTO;
import com.sararf.hotel.booking.module.hotel.dto.HotelDetailsDTO;
import com.sararf.hotel.booking.module.hotel.service.HotelDetailsService;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/app/v1/hotel")
public class HotelController {
	private final HotelDetailsService hotelDetailsService;

	@GetMapping("/search")
	public ResponseEntity<ResponseWrapperDTO<List<HotelDTO>>> search(@RequestParam(required = false) String location,
																	 @RequestParam(required = false) double lat,
																	 @RequestParam(required = false) double lng,
																	 @RequestParam int capacity,
																	 @RequestParam int numOfRooms,
																	 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate,
																	 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOutDate) {
		log.info("Searching hotel by location {} or lat {} and lng {} and capacity {} and numOfRooms {} and checkInDate {} and checkOutDate {}",
				location, lat, lng, capacity, numOfRooms, checkInDate, checkOutDate);
		if (!StringUtils.hasText(location) && (lat == 0 || lng == 0)) {
			return ResponseEntity.badRequest().body(ResponseWrapperDTO.badRequest("Location or lat and lng is required", null));
		}
		List<HotelDTO> hotelDTOList = hotelDetailsService.listOfHotelDTO(location, lat, lng, capacity, numOfRooms, checkInDate, checkOutDate);
		String message = "Hotel found successfully";
		if (Collections.isEmpty(hotelDTOList)) {
			message = "No hotel found";
		}
		return ResponseEntity.ok(ResponseWrapperDTO.ok(hotelDTOList, message));
	}

	@GetMapping("/details")
	public ResponseEntity<ResponseWrapperDTO<HotelDetailsDTO>> hotelDetails(@RequestParam Long hotelId,
																			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate,
																			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOutDate) {
		log.info("Getting hotel details by hotel id {}", hotelId);
		HotelDetailsDTO hotelDetailsDTO = hotelDetailsService.getHotelDetails(hotelId, checkInDate, checkOutDate);
		String message = "Hotel details found successfully";
		if (Objects.isNull(hotelDetailsDTO)) {
			message = "Hotel details not found";
		}
		return ResponseEntity.ok(ResponseWrapperDTO.ok(hotelDetailsDTO, message));
	}
}
