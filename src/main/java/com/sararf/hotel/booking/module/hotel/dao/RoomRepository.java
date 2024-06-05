package com.sararf.hotel.booking.module.hotel.dao;

import com.sararf.hotel.booking.module.booking.dto.RoomRequestDTO;
import com.sararf.hotel.booking.module.hotel.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
	Optional<List<RoomEntity>> findByHotelEntityIdAndIdIn(Long hotelId, List<Long> roomRequestList);

	@Query(
			value = "select new RoomEntity(r.id, r.title, r.type, r.totalRooms, r.pricePerNight, r.bedType," +
					"  r.capacity - IFNULL((select sum(brm.numberOfRooms) from " +
												"BookingRoomMapping brm " +
												"left join BookingEntity b on b.id = brm.bookingEntity.id " +
												"where " +
												"brm.roomEntity.id=r.id and " +
												"date(b.bookingCheckInDate)>=date(:checkInDate) " +
												"and date(b.bookingCheckOutDate)<=date(:checkOutDate) " +
												"and b.hotelEntity.id=:hotelId " +
												"),0)) " +
					"from RoomEntity r " +
					"where r.hotelEntity.id = :hotelId ")
	Optional<List<RoomEntity>> findByHotelEntityId(Long hotelId, Date checkInDate, Date checkOutDate);
}
