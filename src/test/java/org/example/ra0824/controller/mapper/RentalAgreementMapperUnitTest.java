package org.example.ra0824.controller.mapper;

import org.example.ra0824.controller.util.StringUtil;
import org.example.ra0824.model.checkout.CheckoutRequest;
import org.example.ra0824.model.checkout.RentalAgreement;
import org.example.ra0824.model.data.Rental;
import org.example.ra0824.model.data.Tool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RentalAgreementMapperUnitTest {
    final RentalAgreementMapper rentalAgreementMapper = new RentalAgreementMapper();

    @Test
    @DisplayName("Test Scenario 2 from the design doc")
    public void designDocTestScenario2(){
        final CheckoutRequest checkoutRequest = testScenario2();
        final RentalAgreement testResult = rentalAgreementMapper.mapRentalAgreement(checkoutRequest);

        assertEquals(testResult.getToolCode(), Tool.LADDER_WERNER.getCode());
        assertEquals(testResult.getToolType(), Tool.LADDER_WERNER.getType());
        assertEquals(testResult.getToolBrand(), Tool.LADDER_WERNER.getBrand());
        assertEquals(testResult.getRentalDays(), checkoutRequest.getRentalDayCount());
        assertEquals(testResult.getCheckoutDate(), checkoutRequest.getCheckoutDate());
        assertEquals(testResult.getDueDate(), testResult.getCheckoutDate().plusDays(checkoutRequest.getRentalDayCount()));
        assertEquals(testResult.getDailyRentalCharge(), StringUtil.formatAmountUSCurrency(Rental.LADDER.getDailyCharge()));
        assertEquals(testResult.getChargeDays(), 2);
        assertEquals(testResult.getPreDiscountCharge(), StringUtil.formatAmountUSCurrency(3.98));
        assertEquals(testResult.getDiscountPercent(), StringUtil.formatPercent(checkoutRequest.getDiscountPercent()));
        assertEquals(testResult.getDiscountAmount(), StringUtil.formatAmountUSCurrency(0.4));
        assertEquals(testResult.getFinalCharge(), StringUtil.formatAmountUSCurrency(3.58));
    }

    @Test
    @DisplayName("Test Scenario 3 from the design doc")
    public void designDocTestScenario3(){
        final CheckoutRequest checkoutRequest = testScenario3();
        final RentalAgreement testResult = rentalAgreementMapper.mapRentalAgreement(checkoutRequest);

        assertEquals(testResult.getToolCode(), Tool.CHAINSAW_STIHL.getCode());
        assertEquals(testResult.getToolType(), Tool.CHAINSAW_STIHL.getType());
        assertEquals(testResult.getToolBrand(), Tool.CHAINSAW_STIHL.getBrand());
        assertEquals(testResult.getRentalDays(), checkoutRequest.getRentalDayCount());
        assertEquals(testResult.getCheckoutDate(), checkoutRequest.getCheckoutDate());
        assertEquals(testResult.getDueDate(), testResult.getCheckoutDate().plusDays(checkoutRequest.getRentalDayCount()));
        assertEquals(testResult.getDailyRentalCharge(), StringUtil.formatAmountUSCurrency(Rental.CHAINSAW.getDailyCharge()));
        assertEquals(testResult.getChargeDays(), 3);
        assertEquals(testResult.getPreDiscountCharge(), StringUtil.formatAmountUSCurrency(4.47));
        assertEquals(testResult.getDiscountPercent(), StringUtil.formatPercent(checkoutRequest.getDiscountPercent()));
        assertEquals(testResult.getDiscountAmount(), StringUtil.formatAmountUSCurrency(1.12));
        assertEquals(testResult.getFinalCharge(), StringUtil.formatAmountUSCurrency(3.35));
    }

    @Test
    @DisplayName("Test Scenario 4 from the design doc")
    public void designDocTestScenario4(){
        final CheckoutRequest checkoutRequest = testScenario4();
        final RentalAgreement testResult = rentalAgreementMapper.mapRentalAgreement(checkoutRequest);

        assertEquals(testResult.getToolCode(), Tool.JACKHAMMER_DEWALT.getCode());
        assertEquals(testResult.getToolType(), Tool.JACKHAMMER_DEWALT.getType());
        assertEquals(testResult.getToolBrand(), Tool.JACKHAMMER_DEWALT.getBrand());
        assertEquals(testResult.getRentalDays(), checkoutRequest.getRentalDayCount());
        assertEquals(testResult.getCheckoutDate(), checkoutRequest.getCheckoutDate());
        assertEquals(testResult.getDueDate(), testResult.getCheckoutDate().plusDays(checkoutRequest.getRentalDayCount()));
        assertEquals(testResult.getDailyRentalCharge(), StringUtil.formatAmountUSCurrency(Rental.JACKHAMMER.getDailyCharge()));
        assertEquals(testResult.getChargeDays(), 3);
        assertEquals(testResult.getPreDiscountCharge(), StringUtil.formatAmountUSCurrency(8.97));
        assertEquals(testResult.getDiscountPercent(), StringUtil.formatPercent(checkoutRequest.getDiscountPercent()));
        assertEquals(testResult.getDiscountAmount(), StringUtil.formatAmountUSCurrency(0));
        assertEquals(testResult.getFinalCharge(), StringUtil.formatAmountUSCurrency(8.97));
    }

    @Test
    @DisplayName("Test Scenario 5 from the design doc")
    public void designDocTestScenario5(){
        final CheckoutRequest checkoutRequest = testScenario5();
        final RentalAgreement testResult = rentalAgreementMapper.mapRentalAgreement(checkoutRequest);

        assertEquals(testResult.getToolCode(), Tool.JACKHAMMER_RIGID.getCode());
        assertEquals(testResult.getToolType(), Tool.JACKHAMMER_RIGID.getType());
        assertEquals(testResult.getToolBrand(), Tool.JACKHAMMER_RIGID.getBrand());
        assertEquals(testResult.getRentalDays(), checkoutRequest.getRentalDayCount());
        assertEquals(testResult.getCheckoutDate(), checkoutRequest.getCheckoutDate());
        assertEquals(testResult.getDueDate(), testResult.getCheckoutDate().plusDays(checkoutRequest.getRentalDayCount()));
        assertEquals(testResult.getDailyRentalCharge(), StringUtil.formatAmountUSCurrency(Rental.JACKHAMMER.getDailyCharge()));
        assertEquals(testResult.getChargeDays(), 5);
        assertEquals(testResult.getPreDiscountCharge(), StringUtil.formatAmountUSCurrency(14.95));
        assertEquals(testResult.getDiscountPercent(), StringUtil.formatPercent(checkoutRequest.getDiscountPercent()));
        assertEquals(testResult.getDiscountAmount(), StringUtil.formatAmountUSCurrency(0));
        assertEquals(testResult.getFinalCharge(), StringUtil.formatAmountUSCurrency(14.95));
    }

    @Test
    @DisplayName("Test Scenario 6 from the design doc")
    public void designDocTestScenario6(){
        final CheckoutRequest checkoutRequest = testScenario6();
        final RentalAgreement testResult = rentalAgreementMapper.mapRentalAgreement(checkoutRequest);

        assertEquals(testResult.getToolCode(), Tool.JACKHAMMER_RIGID.getCode());
        assertEquals(testResult.getToolType(), Tool.JACKHAMMER_RIGID.getType());
        assertEquals(testResult.getToolBrand(), Tool.JACKHAMMER_RIGID.getBrand());
        assertEquals(testResult.getRentalDays(), checkoutRequest.getRentalDayCount());
        assertEquals(testResult.getCheckoutDate(), checkoutRequest.getCheckoutDate());
        assertEquals(testResult.getDueDate(), testResult.getCheckoutDate().plusDays(checkoutRequest.getRentalDayCount()));
        assertEquals(testResult.getDailyRentalCharge(), StringUtil.formatAmountUSCurrency(Rental.JACKHAMMER.getDailyCharge()));
        assertEquals(testResult.getChargeDays(), 1);
        assertEquals(testResult.getPreDiscountCharge(), StringUtil.formatAmountUSCurrency(2.99));
        assertEquals(testResult.getDiscountPercent(), StringUtil.formatPercent(checkoutRequest.getDiscountPercent()));
        assertEquals(testResult.getDiscountAmount(), StringUtil.formatAmountUSCurrency(1.5));
        assertEquals(testResult.getFinalCharge(), StringUtil.formatAmountUSCurrency(1.5));
    }

    private static CheckoutRequest testScenario2(){
        return CheckoutRequest.builder()
                .toolCode("LADW")
                .rentalDayCount(3)
                .discountPercent(10)
                .checkoutDate(LocalDate.of(2020,7, 2))
                .build();
    }

    private static CheckoutRequest testScenario3(){
        return CheckoutRequest.builder()
                .toolCode("CHNS")
                .rentalDayCount(5)
                .discountPercent(25)
                .checkoutDate(LocalDate.of(2015,7, 2))
                .build();
    }

    private static CheckoutRequest testScenario4(){
        return CheckoutRequest.builder()
                .toolCode("JAKD")
                .rentalDayCount(6)
                .discountPercent(0)
                .checkoutDate(LocalDate.of(2015,9, 3))
                .build();
    }

    private static CheckoutRequest testScenario5(){
        return CheckoutRequest.builder()
                .toolCode("JAKR")
                .rentalDayCount(9)
                .discountPercent(0)
                .checkoutDate(LocalDate.of(2015,7, 2))
                .build();
    }

    private static CheckoutRequest testScenario6(){
        return CheckoutRequest.builder()
                .toolCode("JAKR")
                .rentalDayCount(4)
                .discountPercent(50)
                .checkoutDate(LocalDate.of(2020,7, 2))
                .build();
    }
}
