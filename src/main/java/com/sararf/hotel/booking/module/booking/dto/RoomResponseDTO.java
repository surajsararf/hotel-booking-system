package com.sararf.hotel.booking.module.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDTO {
	private Long roomId;
	private String title;
	private Integer numberOfRooms;
}
