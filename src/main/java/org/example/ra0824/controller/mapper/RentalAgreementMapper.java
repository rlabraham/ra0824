package org.example.ra0824.controller.mapper;

import org.example.ra0824.controller.util.DateUtil;
import org.example.ra0824.controller.util.StringUtil;
import org.example.ra0824.model.checkout.CheckoutRequest;
import org.example.ra0824.model.checkout.RentalAgreement;
import org.example.ra0824.model.data.Rental;
import org.example.ra0824.model.data.Tool;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class RentalAgreementMapper {
    public RentalAgreement mapRentalAgreement(CheckoutRequest checkoutRequest) {
        final Tool tool = Tool.fromCode(checkoutRequest.getToolCode());
        final Rental rental = Rental.valueOf(tool != null ? tool.getType().toUpperCase() : null);

        final LocalDate dueDate = getDueDate(checkoutRequest.getCheckoutDate(), checkoutRequest.getRentalDayCount());
        final long chargeDays = calculateNumberOfChargeDays(checkoutRequest.getCheckoutDate(), dueDate, rental);
        final double preDiscountAmount = rental.getDailyCharge() * chargeDays;
        final double discountAmount = ((checkoutRequest.getDiscountPercent() * 1.0) / 100) * preDiscountAmount;
        final double finalCharge = preDiscountAmount - discountAmount;

        return RentalAgreement.builder()
                .toolCode(checkoutRequest.getToolCode())
                .toolType(tool != null ? tool.getType() : null)
                .toolBrand(tool != null ? tool.getBrand() : null)
                .rentalDays(checkoutRequest.getRentalDayCount())
                .checkoutDate(checkoutRequest.getCheckoutDate())
                .dueDate(dueDate)
                .dailyRentalCharge(StringUtil.formatAmountUSCurrency(rental.getDailyCharge()))
                .chargeDays(chargeDays)
                .preDiscountCharge(StringUtil.formatAmountUSCurrency(preDiscountAmount))
                .discountPercent(StringUtil.formatPercent(checkoutRequest.getDiscountPercent()))
                .discountAmount(StringUtil.formatAmountUSCurrency(discountAmount))
                .finalCharge(StringUtil.formatAmountUSCurrency(finalCharge))
                .build();
    }


    private LocalDate getDueDate(final LocalDate startDate, final long days) {
        return startDate.plusDays(days);
    }

    private long calculateNumberOfChargeDays(final LocalDate checkoutDate, final LocalDate dueDate, final Rental rental) {
       final long daysBetween = DAYS.between(checkoutDate, dueDate);
       final long noChargeDays = calculateNumberOfNoChargeDays(checkoutDate, dueDate, rental);

       return daysBetween - noChargeDays;
    }

    private long calculateNumberOfNoChargeDays(final LocalDate checkoutDate, final LocalDate dueDate, final Rental rental) {
        long noChargeDays = 0;

        if (rental != null) {
            LocalDate pointerDate = checkoutDate.plusDays(1);

            while (DateUtil.onOrBefore(pointerDate, dueDate)) {
                if (!rental.isWeekdayCharge() && DateUtil.WEEK_DAYS.contains(pointerDate.getDayOfWeek())) {
                    noChargeDays++;
                }

                if (!rental.isWeekendCharge() && DateUtil.WEEKEND_DAYS.contains(pointerDate.getDayOfWeek())) {
                    noChargeDays++;
                }

                pointerDate = pointerDate.plusDays(1);
            }

            if (!rental.isHolidayCharge()) {
                noChargeDays = noChargeDays + calculateNumberOfHolidays(checkoutDate, dueDate);
            }
        }

        return noChargeDays;
    }

    private long calculateNumberOfHolidays(final LocalDate checkoutDate, final LocalDate dueDate) {
        long numberOfNoChargeDays = 0;

        for (int year = checkoutDate.plusDays(1).getYear(); year <= dueDate.getYear(); year++){
            final LocalDate independenceDay = DateUtil.getIndependenceDay(year);
            final LocalDate laborDay = DateUtil.getLaborDay(year);

            if (DateUtil.onOrAfter(independenceDay, checkoutDate) && DateUtil.onOrBefore(independenceDay, dueDate)) {
                numberOfNoChargeDays++;
            }

            if (DateUtil.onOrAfter(laborDay, checkoutDate) && DateUtil.onOrBefore(laborDay, dueDate)) {
                numberOfNoChargeDays++;
            }

        }

        return numberOfNoChargeDays;
    }
}
