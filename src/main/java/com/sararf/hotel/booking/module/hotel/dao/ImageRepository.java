package com.sararf.hotel.booking.module.hotel.dao;

import com.sararf.hotel.booking.module.hotel.entity.ImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImagesEntity, Long> {
	List<ImagesEntity> findByHotelEntityId(Long hotelId);

	List<ImagesEntity> findByRoomEntityId(Long roomId);
}
