package org.example.ra0824.controller;

import org.example.ra0824.ApplicationConstants;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CheckoutControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private static final String ENDPOINT = "/checkout";

    @Test
    @DisplayName("CheckoutController - Happy path")
    public void happyPath() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT)
                                .content(happyPathTest())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Test Scenario 1 from the design doc")
    public void designDocTestScenario1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT)
                        .content(requiredTest1())
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.discountPercent", Is.is(ApplicationConstants.DISCOUNT_MAX_VALIDATION_MSG)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Request Validation Errors")
    public void requestValidationErrors() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT)
                                .content(invalidRequest())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.toolCode", Is.is(ApplicationConstants.TOOL_CODE_BLANK_VALIDATION_MSG)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rentalDayCount", Is.is(ApplicationConstants.RENTAL_DAY_MIN_VALIDATION_MSG)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.discountPercent", Is.is(ApplicationConstants.DISCOUNT_MIN_VALIDATION_MSG)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.checkoutDate", Is.is(ApplicationConstants.CHECKOUT_DATE_BLANK_VALIDATION_MSG)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    private static String happyPathTest() {
        return "{\"Tool code\":\"JAKR\",\"Rental day count\":5,\"Discount percent\":10,\n\"Checkout date\":\"09/03/15\"}";
    }

    private static String requiredTest1() {
        return "{\"Tool code\":\"JAKR\",\"Rental day count\":5,\"Discount percent\":101,\n\"Checkout date\":\"09/03/15\"}";
    }

    private static String invalidRequest() {
        return "{\"Tool code\":\"  \",\"Rental day count\":0,\"Discount percent\":-1,\n\"Checkout date\":\"  \"}";
    }
}
