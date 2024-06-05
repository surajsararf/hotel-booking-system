package com.sararf.hotel.booking.module.booking.dao;

import com.sararf.hotel.booking.module.booking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
	@Transactional
	@Query(nativeQuery = true, value = "SELECT * FROM bookings WHERE id = ?1 " +
			"and booking_status In ('PENDING','CONFIRMED') and booking_check_in_date>CURRENT_TIMESTAMP " +
			"FOR UPDATE ")
	BookingEntity findForCancelEntity(Long bookingId, String status);

	Optional<BookingEntity> findByIdAndUserId(Long bookingId, Long userId);

	Optional<List<BookingEntity>> findByUserId(Long userId);
}

