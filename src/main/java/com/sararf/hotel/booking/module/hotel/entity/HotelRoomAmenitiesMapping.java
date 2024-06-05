package com.sararf.hotel.booking.module.hotel.entity;

import com.sararf.hotel.booking.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Table(name = "hotel_room_amenities_mapping")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HotelRoomAmenitiesMapping extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private RoomEntity roomEntity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id")
	private HotelEntity hotelEntity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "amenity_id")
	private AmenitiesEntity amenitiesEntity;
}
