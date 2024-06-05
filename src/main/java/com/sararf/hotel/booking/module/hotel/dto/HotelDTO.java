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
public class HotelDTO {
	private Long id;
	private String name;
	private String location;
	private String address;
	private double rating;
	private List<ImageDTO> images;
	private List<String> amenities;
	private double startingPrice;

	public HotelDTO(Long id, String name, String location, String address,
					double rating, double startingPrice) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.address = address;
		this.rating = rating;
		this.startingPrice = startingPrice;
	}
}
