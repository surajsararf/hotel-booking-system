package com.sararf.hotel.booking.module.hotel.entity;

import com.sararf.hotel.booking.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "hotels")
public class HotelEntity extends BaseEntity {
	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "lat")
	private double lat;

	@Column(name = "lan")
	private double lan;

	@Column(name = "rating")
	private double rating;
	@Column(name = "address")
	private String address;
}
