package com.sararf.hotel.booking.module.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDTO {
	@NotNull(message = "Room id can not be null")
	private Long roomId;
	@NotNull(message = "numbers of room can not be null")
	private Integer numberOfRooms;
}
