package com.sararf.hotel.booking.module.booking.dao;

import com.sararf.hotel.booking.module.booking.entity.BookingRoomMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRoomMappingRepository extends JpaRepository<BookingRoomMapping, Long> {
	Optional<List<BookingRoomMapping>> findByBookingEntityId(Long bookingId);
}
