package org.example.ra0824.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ra0824.controller.service.CheckoutService;
import org.example.ra0824.model.checkout.CheckoutRequest;
import org.example.ra0824.model.checkout.RentalAgreement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/checkout")
@RestController
@AllArgsConstructor
@Slf4j
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping
    public Mono<RentalAgreement> createRentalAgreement(@RequestBody CheckoutRequest checkoutRequest) {
        log.info("Checkout request: {}", checkoutRequest);
        return checkoutService.createRentalAgreement(checkoutRequest);
    }
}
