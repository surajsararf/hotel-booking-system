package com.sararf.hotel.booking.module.booking.entity;

import com.sararf.hotel.booking.entity.BaseEntity;
import com.sararf.hotel.booking.module.hotel.entity.RoomEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "booking_room_mapping")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingRoomMapping extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booking_id")
	private BookingEntity bookingEntity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private RoomEntity roomEntity;
	@Column(name = "number_of_rooms")
	private Integer numberOfRooms;
}
