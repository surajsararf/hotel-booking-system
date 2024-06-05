package com.sararf.hotel.booking.module.booking.enums;

public class BookingEnum {
	public enum PaymentStatus {
		PENDING,
		CANCELLED, PAID
	}

	public enum PaymentMode {
		CARD
	}

	public enum BookingStatus {
		PENDING,
		CONFIRMED,
		CANCELLED
	}
}
