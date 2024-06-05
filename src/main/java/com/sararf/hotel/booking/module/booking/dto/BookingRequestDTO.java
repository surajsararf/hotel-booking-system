package com.sararf.hotel.booking.module.booking.dto;

import com.sararf.hotel.booking.common.validation.ValidDateRange;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ValidDateRange
public class BookingRequestDTO {
	@NotNull(message = "Hotel id can not be null")
	private Long hotelId;
	@NotEmpty(message = "Room details can not be null")
	private List<RoomRequestDTO> roomRequestList;
	@NotNull(message = "check in date can not be null")
	private Date checkInDate;
	@NotNull(message = "check out date can not be null")
	private Date checkOutDate;
	@NotNull(message = "Total Guests can not be null")
	private Integer totalGuest;
}
