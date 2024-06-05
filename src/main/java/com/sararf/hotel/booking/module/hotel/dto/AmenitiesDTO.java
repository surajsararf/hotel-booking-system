package com.sararf.hotel.booking.module.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmenitiesDTO {
	private Long id;
	private String title;
	private String description;
}
