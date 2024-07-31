package org.example.ra0824.controller.service;

import lombok.AllArgsConstructor;
import org.example.ra0824.controller.mapper.RentalAgreementMapper;
import org.example.ra0824.model.checkout.CheckoutRequest;
import org.example.ra0824.model.checkout.RentalAgreement;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service @AllArgsConstructor
public class CheckoutService {
    private final RentalAgreementMapper rentalAgreementMapper;

    public Mono<RentalAgreement> createRentalAgreement(CheckoutRequest checkoutRequest) {
        return Mono.just(rentalAgreementMapper.mapRentalAgreement(checkoutRequest));
    }
}
