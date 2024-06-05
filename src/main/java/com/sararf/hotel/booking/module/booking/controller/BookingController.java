package com.sararf.hotel.booking.module.booking.controller;

import com.sararf.hotel.booking.common.ResponseWrapperDTO;
import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.booking.dto.BookingRequestDTO;
import com.sararf.hotel.booking.module.booking.dto.BookingResponseDTO;
import com.sararf.hotel.booking.module.booking.service.CancelBookingService;
import com.sararf.hotel.booking.module.booking.service.CreateBookingService;
import com.sararf.hotel.booking.module.booking.service.DetailBookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/app/v1/booking")
public class BookingController {
	private final CancelBookingService cancelBookingService;
	private final CreateBookingService createBookingService;
	private final DetailBookingService detailBookingService;

	@GetMapping("/list")
	private ResponseEntity<ResponseWrapperDTO<List<BookingResponseDTO>>> fetchList() {
		log.info("Fetching booking list");
		return ResponseEntity.ok(ResponseWrapperDTO
				.ok(detailBookingService
						.bookingList(getUser()), "Successfully fetch list"));
	}

	@PatchMapping("/cancel")
	private ResponseEntity<ResponseWrapperDTO<BookingResponseDTO>> cancelBooking(@RequestParam Long bookingId) {
		log.info("Cancelling booking");
		return ResponseEntity.ok(ResponseWrapperDTO
				.ok(cancelBookingService.cancelBooking(bookingId, getUser()),
						"Successfully cancelled booking"));
	}

	@PostMapping("/create")
	private ResponseEntity<ResponseWrapperDTO<BookingResponseDTO>> createBooking
			(@RequestBody @Valid BookingRequestDTO bookingRequestDTO) {
		log.info("Creating booking");
		return ResponseEntity.ok(ResponseWrapperDTO
				.ok(createBookingService.createBooking(bookingRequestDTO, getUser()),
						"Successfully created booking"));
	}

	private UserEntity getUser() {
		return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
