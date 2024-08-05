package org.example.ra0824.model.checkout;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ra0824.ApplicationConstants;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CheckoutRequest {
    @NotBlank(message = ApplicationConstants.TOOL_CODE_BLANK_VALIDATION_MSG)
    @JsonProperty("Tool code")
    private String toolCode;

    @Min(value = 1, message = ApplicationConstants.RENTAL_DAY_MIN_VALIDATION_MSG)
    @JsonProperty("Rental day count")
    private long rentalDayCount;

    @Min(value = 0, message = ApplicationConstants.DISCOUNT_MIN_VALIDATION_MSG)
    @Max(value = 100, message = ApplicationConstants.DISCOUNT_MAX_VALIDATION_MSG)
    @JsonProperty("Discount percent")
    private int discountPercent;

    @NotNull(message = ApplicationConstants.CHECKOUT_DATE_BLANK_VALIDATION_MSG)
    @JsonProperty("Checkout date")
    @JsonFormat(pattern = "M/d/yy")
    private LocalDate checkoutDate;
}
