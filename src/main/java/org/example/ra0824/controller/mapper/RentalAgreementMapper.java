package org.example.ra0824.controller.mapper;

import org.example.ra0824.model.checkout.CheckoutRequest;
import org.example.ra0824.model.checkout.RentalAgreement;
import org.springframework.stereotype.Component;

@Component
public class RentalAgreementMapper {
    public RentalAgreement mapRentalAgreement(CheckoutRequest checkoutRequest) {
        RentalAgreement rentalAgreement = new RentalAgreement();
        return rentalAgreement;
    }
}
