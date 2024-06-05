package com.sararf.hotel.booking.module.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDetailsDTO {
	private Long id;
	private String name;
	private List<ImageDTO> images;
	private double price;
	private List<String> amenities;
	private String description;
	private int capacity;
	private boolean isAvailable;
	private String roomType;
	private String bedType;
}
