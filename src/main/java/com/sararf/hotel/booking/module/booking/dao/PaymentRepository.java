package com.sararf.hotel.booking.module.booking.dao;

import com.sararf.hotel.booking.module.booking.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
