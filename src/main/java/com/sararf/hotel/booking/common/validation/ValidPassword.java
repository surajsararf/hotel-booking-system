package com.sararf.hotel.booking.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Password must contain at least one digit, one uppercase letter, and one special character";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
