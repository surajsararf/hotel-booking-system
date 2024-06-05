package com.sararf.hotel.booking.common.validation;

import com.sararf.hotel.booking.module.booking.dto.BookingRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, BookingRequestDTO> {

	@Override
	public void initialize(ValidDateRange constraintAnnotation) {
	}

	@Override
	public boolean isValid(BookingRequestDTO bookingRequestDTO, ConstraintValidatorContext context) {
		if (bookingRequestDTO.getCheckInDate() == null || bookingRequestDTO.getCheckOutDate() == null) {
			return true; // @NotNull will handle this case
		}

		return bookingRequestDTO.getCheckOutDate().after(bookingRequestDTO.getCheckInDate())
				&& bookingRequestDTO.getCheckInDate().after(new Date());
	}
}

