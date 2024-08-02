package org.example.ra0824.controller.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

public final class DateUtil {
    public static final List<DayOfWeek> WEEK_DAYS = Arrays.asList(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY
    );

    public static final List<DayOfWeek> WEEKEND_DAYS = Arrays.asList(
            DayOfWeek.SATURDAY,
            DayOfWeek.SUNDAY
    );

    private DateUtil(){}

    public static LocalDate getIndependenceDay(int year) {
        LocalDate independenceDay = LocalDate.of(year, Month.JULY, 4);

        if (independenceDay.getDayOfWeek() == DayOfWeek.SATURDAY) {
            independenceDay = independenceDay.minusDays(1);
        } else if (independenceDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            independenceDay = independenceDay.plusDays(1);
        }

        return independenceDay;
    }

    public static LocalDate getLaborDay(int year) {
        return LocalDate.of(year, Month.SEPTEMBER, 1).with(firstInMonth(DayOfWeek.MONDAY));
    }

    public static boolean onOrAfter(LocalDate d1, LocalDate d2) {
        return d1.isEqual(d2) || d1.isAfter(d2);
    }

    public static boolean onOrBefore(LocalDate d1, LocalDate d2) {
        return d1.isEqual(d2) || d1.isBefore(d2);
    }
}
