package com.sararf.hotel.booking.module.booking.controller;

import com.sararf.hotel.booking.common.dto.ResponseWrapperDTO;
import com.sararf.hotel.booking.entity.UserEntity;
import com.sararf.hotel.booking.module.booking.dto.BookingRequestDTO;
import com.sararf.hotel.booking.module.booking.dto.BookingResponseDTO;
import com.sararf.hotel.booking.module.booking.service.CancelBookingService;
import com.sararf.hotel.booking.module.booking.service.CreateBookingService;
import com.sararf.hotel.booking.module.booking.service.DetailBookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Booking APIs", value = "Booking APIs")
public class BookingController {
	private final CancelBookingService cancelBookingService;
	private final CreateBookingService createBookingService;
	private final DetailBookingService detailBookingService;

	@GetMapping("/list")
	@ApiOperation(value = "Fetch booking list", notes = "Fetch booking list")
	private ResponseEntity<ResponseWrapperDTO<List<BookingResponseDTO>>> fetchList() {
		log.info("Fetching booking list");
		return ResponseEntity.ok(ResponseWrapperDTO
				.ok(detailBookingService
						.bookingList(getUser()), "Successfully fetch list"));
	}

	@PatchMapping("/cancel")
	@ApiOperation(value = "Cancel booking", notes = "Cancel booking")
	private ResponseEntity<ResponseWrapperDTO<BookingResponseDTO>> cancelBooking(@RequestParam Long bookingId) {
		log.info("Cancelling booking");
		return ResponseEntity.ok(ResponseWrapperDTO
				.ok(cancelBookingService.cancelBooking(bookingId, getUser()),
						"Successfully cancelled booking"));
	}

	@PostMapping("/create")
	@ApiOperation(value = "Create booking", notes = "Create booking")
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
