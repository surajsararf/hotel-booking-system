package com.sararf.hotel.booking.module.booking.entity;

import com.sararf.hotel.booking.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "payment")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity extends BaseEntity {
	@Column(name = "payment_status")
	private String paymentStatus;
	@Column(name = "payment_mode")
	private String paymentMode;
	@Column(name = "payment_amount")
	private double paymentAmount;
	@Column(name = "order_id")
	private String orderId;
}
