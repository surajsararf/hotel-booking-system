package com.sararf.hotel.booking.module.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDetailsDTO {
	private Long id;
	private String name;
	private String location;
	private String address;
	private double rating;
	private List<RoomDetailsDTO> rooms;
}
