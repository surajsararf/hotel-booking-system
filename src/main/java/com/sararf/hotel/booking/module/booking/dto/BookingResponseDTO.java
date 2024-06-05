package com.sararf.hotel.booking.module.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {
	private Long bookingId;
	private String bookingStatus;
	private Long paymentId;
	private Double bookingAmount;
	private String orderId;
	private int numberOfGuest;
	private List<RoomResponseDTO> responseDTOS;
	private Date bookingCheckInDate;
	private Date bookingCheckOutDate;
	private String hotelName;
	private String address;
	private double lat;
	private double lng;
}
