package org.example.ra0824.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ra0824.controller.service.CheckoutService;
import org.example.ra0824.model.checkout.CheckoutRequest;
import org.example.ra0824.model.checkout.RentalAgreement;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/checkout")
@RestController
@AllArgsConstructor
@Slf4j
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping
    public Mono<RentalAgreement> createRentalAgreement(@Valid @RequestBody CheckoutRequest checkoutRequest) {
        log.info("Checkout request: {}", checkoutRequest);
        return checkoutService.createRentalAgreement(checkoutRequest);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}
