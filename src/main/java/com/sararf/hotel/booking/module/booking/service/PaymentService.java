package com.sararf.hotel.booking.module.booking.service;

import com.sararf.hotel.booking.module.booking.entity.PaymentEntity;

public interface PaymentService {
	PaymentEntity createPayment(Double amount);
	PaymentEntity savePayment(PaymentEntity paymentEntity);
	PaymentEntity cancelPayment(Long paymentId, String name);
	PaymentEntity findById(Long paymentId);
}
