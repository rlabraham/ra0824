package org.example.ra0824.controller.service;

import org.example.ra0824.controller.mapper.RentalAgreementMapper;
import org.example.ra0824.model.checkout.CheckoutRequest;
import org.example.ra0824.model.checkout.RentalAgreement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.mockito.Mockito.when;


@SpringBootTest
public class CheckoutServiceUnitTest {
    RentalAgreementMapper rentalAgreementMapper = Mockito.mock(RentalAgreementMapper.class);
    CheckoutService checkoutService = new CheckoutService(rentalAgreementMapper);

    @Test
    @DisplayName("CheckoutService - Happy path")
    public void checkoutServiceHappyPath() {
        final CheckoutRequest checkoutRequest = new CheckoutRequest();

        when(rentalAgreementMapper.mapRentalAgreement(checkoutRequest)).thenReturn(happyPathRentalAgreement());

        final Mono<RentalAgreement> testResult = checkoutService.createRentalAgreement(checkoutRequest);

        StepVerifier.create(testResult)
                .expectNext(happyPathRentalAgreement())
                .verifyComplete();
    }

    private static RentalAgreement happyPathRentalAgreement() {
        return RentalAgreement.builder()
                .toolCode("tool code")
                .toolType("tool type")
                .toolBrand("tool brand")
                .rentalDays(1L)
                .checkoutDate(LocalDate.MIN)
                .dueDate(LocalDate.MAX)
                .dailyRentalCharge("$1.00")
                .chargeDays(1L)
                .preDiscountCharge("$2.00")
                .discountPercent("50%")
                .discountAmount("$3.00")
                .finalCharge("$4.00")
                .build();
    }
}
