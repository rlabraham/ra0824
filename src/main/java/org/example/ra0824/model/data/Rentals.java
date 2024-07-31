package org.example.ra0824.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum Rentals {
    LADDER(1.99, true, true, false),
    CHAINSAW(1.49, true, false, true),
    JACKHAMMER(2.99, true, false, false);

    private final double dailyCharge;
    private final boolean weekdayCharge;
    private final boolean weekendCharge;
    private final boolean holidayCharge;
}
