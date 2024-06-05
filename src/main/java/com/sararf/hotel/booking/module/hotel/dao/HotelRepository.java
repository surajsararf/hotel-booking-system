package com.sararf.hotel.booking.module.hotel.dao;

import com.sararf.hotel.booking.module.hotel.dto.HotelDTO;
import com.sararf.hotel.booking.module.hotel.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

	@Query(value = "SELECT new com.sararf.hotel.booking.module.hotel.dto.HotelDTO(h.id, h.name, h.location, h.address, h.rating, MIN(r.pricePerNight)) " +
			"FROM HotelEntity h " +
			"JOIN RoomEntity r ON r.hotelEntity.id = h.id " +
			"WHERE " +
			"(h.location = :location " +
			"or (6371 * acos(cos(radians(:lat)) * cos(radians(h.lat)) * cos(radians(h.lan) - radians(:lng)) + sin(radians(:lat)) * sin(radians(h.lat))) <= 5)) " +
			"And r.totalRooms >= :roomRequired " +
			"And r.capacity>= :capacity " +
			"AND r.id NOT IN ( " +
			"    SELECT brm.roomEntity.id " +
			"    FROM BookingRoomMapping brm " +
			"    JOIN brm.bookingEntity b " +
			"    WHERE " +
			"((date(b.bookingCheckInDate)<=date(:checkInDate) " +
			"and date(b.bookingCheckOutDate)>=date(:checkInDate) ) OR" +
			"(date(b.bookingCheckInDate)<=date(:checkOutDate) " +
			"and date(b.bookingCheckOutDate)>=date(:checkOutDate) ))" +
			"    GROUP BY brm.roomEntity.id " +
			"    HAVING SUM(brm.numberOfRooms) + :roomRequired > r.totalRooms " +
			") " +
			"GROUP BY h.id, h.name, h.location, h.address, h.rating")
	List<HotelDTO> fetchByLocationOrLatLng(String location, double lat, double lng, int capacity, Date checkInDate, Date checkOutDate, int roomRequired);
}
