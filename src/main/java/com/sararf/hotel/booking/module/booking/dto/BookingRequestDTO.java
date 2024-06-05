package com.sararf.hotel.booking.module.booking.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingRequestDTO {
	private Long hotelId;
	private List<RoomRequestDTO> roomRequestList;
	private Date checkInDate;
	private Date checkOutDate;
	private int totalGuest;
}
