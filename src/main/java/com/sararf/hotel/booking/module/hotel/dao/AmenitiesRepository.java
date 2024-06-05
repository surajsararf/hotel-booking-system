package com.sararf.hotel.booking.module.hotel.dao;

import com.sararf.hotel.booking.module.hotel.dto.AmenitiesDTO;
import com.sararf.hotel.booking.module.hotel.entity.AmenitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenitiesRepository extends JpaRepository<AmenitiesEntity, Long> {
	@Query(nativeQuery = true, value = "select a.title " +
			"from amenities a " +
			"join hotel_room_amenities_mapping hta " +
			"on a.id = hta.amenity_id " +
			"where hta.hotel_id = ?1")
	List<String> findAmenitiesByHotelId(Long hotelId);

	@Query(nativeQuery = true, value = "select a.title " +
			"from amenities a " +
			"join hotel_room_amenities_mapping hta " +
			"on a.id = hta.amenity_id " +
			"where hta.room_id = ?1")
	List<String> findAmenitiesByRoomId(Long roomId);
}
