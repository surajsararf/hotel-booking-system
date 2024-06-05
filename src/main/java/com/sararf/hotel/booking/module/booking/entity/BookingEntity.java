package com.sararf.hotel.booking.module.booking.entity;

import com.sararf.hotel.booking.entity.BaseEntity;
import com.sararf.hotel.booking.module.hotel.entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingEntity extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id")
	private HotelEntity hotelEntity;
	@Column(name = "booking_amount")
	private Double bookingAmount;
	@Column(name = "booking_status")
	private String bookingStatus;
	@Column(name = "booking_check_in_date")
	private Date bookingCheckInDate;
	@Column(name = "booking_check_out_date")
	private Date bookingCheckOutDate;
	@Column(name = "order_id")
	private String orderId;
	@Column(name = "payment_id")
	private Long paymentId;
	@Column(name = "total_guest")
	private int totalGuest;
	@Column(name = "user_id")
	private Long userId;
}
