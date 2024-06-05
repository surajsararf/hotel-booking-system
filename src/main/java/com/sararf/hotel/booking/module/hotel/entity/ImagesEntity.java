package com.sararf.hotel.booking.module.hotel.entity;

import com.sararf.hotel.booking.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "images")
public class ImagesEntity extends BaseEntity {
	@Column(name = "image_url")
	private String imageUrl;
	@ManyToOne(targetEntity = RoomEntity.class, fetch = javax.persistence.FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private RoomEntity roomEntity;
	@ManyToOne(fetch = javax.persistence.FetchType.LAZY)
	@JoinColumn(name = "hotel_id")
	private HotelEntity hotelEntity;
	@Column(name = "image_type")
	private String imageType;
}
