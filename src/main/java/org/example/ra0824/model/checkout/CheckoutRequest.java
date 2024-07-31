package org.example.ra0824.model.checkout;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest {
    @NotBlank(message = "Tool Code must not be blank")
    private String toolCode;

    @Min(value = 1, message = "Rental Day Count must be 1 or greater")
    private long rentalDayCount;

    @Min(value = 0, message = "Discount Percent must be 0 or greater")
    @Max(value = 100, message = "Discount Percent must be 100 or less")
    private int discountPercent;

    private LocalDate checkoutDate;
}
