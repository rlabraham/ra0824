package org.example.ra0824.model.checkout;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest {
    @NotBlank(message = "Tool Code must not be blank")
    @JsonProperty("Tool code")
    private String toolCode;

    @Min(value = 1, message = "Rental Day Count must be 1 or greater")
    @JsonProperty("Rental day count")
    private long rentalDayCount;

    @Min(value = 0, message = "Discount Percent must be 0 or greater")
    @Max(value = 100, message = "Discount Percent must be 100 or less")
    @JsonProperty("Discount percent")
    private int discountPercent;

    @NotNull(message = "Checkout Date must not be blank")
    @JsonProperty("Checkout date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "M/d/yy")
    private LocalDate checkoutDate;
}
