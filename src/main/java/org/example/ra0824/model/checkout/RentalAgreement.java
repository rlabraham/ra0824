package org.example.ra0824.model.checkout;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class RentalAgreement {
    @JsonProperty("Tool code")
    private String toolCode;

    @JsonProperty("Tool type")
    private String toolType;

    @JsonProperty("Tool brand")
    private String toolBrand;

    @JsonProperty("Rental days")
    private Long rentalDays;

    @JsonProperty("Checkout date")
    @JsonFormat(pattern = "M/d/yy")
    private LocalDate checkoutDate;

    @JsonProperty("Due date")
    @JsonFormat(pattern = "M/d/yy")
    private LocalDate dueDate;

    @JsonProperty("Daily rental charge")
    private String dailyRentalCharge;

    @JsonProperty("Charge days")
    private Long chargeDays;

    @JsonProperty("Pre-discount charge")
    private String preDiscountCharge;

    @JsonProperty("Discount percent")
    private String discountPercent;

    @JsonProperty("Discount amount")
    private String discountAmount;

    @JsonProperty("Final charge")
    private String finalCharge;
}
