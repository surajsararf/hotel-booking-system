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
@Table(name = "amenities")
public class AmenitiesEntity extends BaseEntity {
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
}
