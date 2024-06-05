package com.sararf.hotel.booking.module.hotel.entity;

import com.sararf.hotel.booking.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity extends BaseEntity {
	@Column(name = "title")
	private String title;
	@Column(name = "type")
	private String type;
	@Column(name = "total_rooms")
	private int totalRooms;
	@Column(name = "price_per_night")
	private double pricePerNight;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id")
	private HotelEntity hotelEntity;
	@Column(name = "capacity")
	private Integer capacity;
	@Column(name = "bed_type")
	private String bedType;

	public RoomEntity(Long id, String title, String type, int capacity, double pricePerNight, String bedType, int totalRooms) {
		setId(id);
		this.title = title;
		this.type = type;
		this.totalRooms = totalRooms;
		this.pricePerNight = pricePerNight;
		this.capacity = capacity;
		this.bedType = bedType;
	}
}
