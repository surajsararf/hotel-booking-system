package com.sararf.hotel.booking.utils;

import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.booking.dto.BookingRequestDTO;
import com.sararf.hotel.booking.module.booking.dto.BookingResponseDTO;
import com.sararf.hotel.booking.module.booking.dto.RoomResponseDTO;
import com.sararf.hotel.booking.module.booking.entity.BookingEntity;
import com.sararf.hotel.booking.module.booking.entity.BookingRoomMapping;
import com.sararf.hotel.booking.module.booking.entity.PaymentEntity;
import com.sararf.hotel.booking.module.booking.enums.BookingEnum;
import com.sararf.hotel.booking.module.hotel.dto.AmenitiesDTO;
import com.sararf.hotel.booking.module.hotel.dto.HotelDetailsDTO;
import com.sararf.hotel.booking.module.hotel.dto.RoomDetailsDTO;
import com.sararf.hotel.booking.module.hotel.entity.HotelEntity;
import com.sararf.hotel.booking.module.hotel.entity.ImagesEntity;
import com.sararf.hotel.booking.module.hotel.entity.RoomEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class BookingUtils {
	public String getOrderId(Long pid) {
		return "OR-" + pid + System.currentTimeMillis();
	}

	public PaymentEntity payments(Double amount) {
		return PaymentEntity.builder()
				.paymentAmount(amount)
				.paymentMode(BookingEnum.PaymentMode.CARD.name())
				.paymentStatus(BookingEnum.PaymentStatus.PAID.name())
				.build();
	}

	public BookingEntity toBookingEntity(BookingRequestDTO bookingRequestDTO, PaymentEntity paymentEntity,
										 UserEntity userEntity, HotelEntity hotelEntity, Double amount) {
		return BookingEntity.builder()
				.userId(userEntity.getId())
				.totalGuest(bookingRequestDTO.getTotalGuest())
				.bookingAmount(amount)
				.bookingCheckInDate(bookingRequestDTO.getCheckInDate())
				.bookingCheckOutDate(bookingRequestDTO.getCheckOutDate())
				.bookingStatus(BookingEnum.BookingStatus.CONFIRMED.name())
				.paymentId(paymentEntity.getId())
				.orderId(paymentEntity.getOrderId())
				.hotelEntity(hotelEntity)
				.build();
	}


	public List<BookingRoomMapping> toBookingRoomMapping(BookingRequestDTO bookingRequestDTO,
														 BookingEntity bookingEntity, List<RoomEntity> roomEntityList) {
		List<BookingRoomMapping> list = new ArrayList<>();
		for (RoomEntity roomEntity : roomEntityList) {
			BookingRoomMapping bookingRoomMapping = BookingRoomMapping.builder()
					.bookingEntity(bookingEntity)
					.roomEntity(roomEntity)
					.numberOfRooms(bookingRequestDTO.getRoomRequestList().stream()
							.filter(roomRequestDTO -> roomRequestDTO.getRoomId().equals(roomEntity.getId()))
							.findFirst()
							.orElseThrow(() -> new RuntimeException("Room not found"))
							.getNumberOfRooms())
					.build();
			list.add(bookingRoomMapping);
		}
		return list;
	}

	public double calculateBookingAmount(List<RoomEntity> roomEntityList, BookingRequestDTO bookingRequestDTO) {
		return roomEntityList.stream()
				.mapToDouble(roomEntity -> roomEntity.getPricePerNight() * bookingRequestDTO.getRoomRequestList()
						.stream()
						.filter(roomRequestDTO -> roomRequestDTO.getRoomId().equals(roomEntity.getId()))
						.findFirst()
						.orElseThrow(() -> new RuntimeException("Room not found"))
						.getNumberOfRooms())
				.sum();
	}

	public BookingResponseDTO toBookingResponseDTO(BookingEntity bookingEntity, List<BookingRoomMapping> bookingRoomMappingList) {
		return BookingResponseDTO.builder()
				.bookingId(bookingEntity.getId())
				.bookingAmount(bookingEntity.getBookingAmount())
				.bookingCheckInDate(bookingEntity.getBookingCheckInDate())
				.bookingCheckOutDate(bookingEntity.getBookingCheckOutDate())
				.bookingStatus(bookingEntity.getBookingStatus())
				.hotelName(bookingEntity.getHotelEntity().getName())
				.address(bookingEntity.getHotelEntity().getAddress())
				.lat(bookingEntity.getHotelEntity().getLat())
				.lng(bookingEntity.getHotelEntity().getLan())
				.numberOfGuest(bookingEntity.getTotalGuest())
				.orderId(bookingEntity.getOrderId())
				.responseDTOS(bookingRoomMappingList.stream()
						.map(roomEntity -> RoomResponseDTO.builder()
								.roomId(roomEntity.getRoomEntity().getId())
								.title(roomEntity.getRoomEntity().getTitle())
								.numberOfRooms(roomEntity.getNumberOfRooms())
								.build())
						.collect(Collectors.toList()))
				.paymentId(bookingEntity.getPaymentId())
				.orderId(bookingEntity.getOrderId())
				.build();
	}

	public BookingResponseDTO toBookingResponseDTO(BookingEntity bookingEntity) {
		return BookingResponseDTO.builder()
				.bookingId(bookingEntity.getId())
				.orderId(bookingEntity.getOrderId())
				.bookingAmount(bookingEntity.getBookingAmount())
				.hotelName(bookingEntity.getHotelEntity().getName())
				.bookingStatus(bookingEntity.getBookingStatus())
				.build();
	}

	public static HotelDetailsDTO toHotelDetailsDTO(HotelEntity hotelEntity, List<RoomEntity> roomEntityList) {
		return HotelDetailsDTO.builder()
				.id(hotelEntity.getId())
				.name(hotelEntity.getName())
				.location(hotelEntity.getLocation())
				.address(hotelEntity.getAddress())
				.rating(hotelEntity.getRating())
				.rooms(roomEntityList.stream()
						.map(roomEntity -> RoomDetailsDTO.builder()
								.id(roomEntity.getId())
								.name(roomEntity.getTitle())
								.price(roomEntity.getPricePerNight())
								.capacity(roomEntity.getCapacity())
								.numberOfRooms(roomEntity.getTotalRooms())
								.bedType(roomEntity.getBedType())
								.isAvailable(roomEntity.getTotalRooms() > 0)
								.build())
						.collect(Collectors.toList()))

				.build();
	}
}
