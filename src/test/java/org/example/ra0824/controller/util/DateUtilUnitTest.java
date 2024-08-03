package org.example.ra0824.controller.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DateUtilUnitTest {
    @Test
    @DisplayName("getIndependenceDay - July 4th on a weekday")
    public void fourthOnWeekday(){
        final LocalDate testResult = DateUtil.getIndependenceDay(2023);

        assertEquals(testResult.getMonth(), Month.JULY);
        assertEquals(testResult.getDayOfMonth(), 4);
        assertEquals(testResult.getYear(), 2023);
    }

    @Test
    @DisplayName("getIndependenceDay - July 4th on a Saturday")
    public void fourthOnSaturday(){
        final LocalDate testResult = DateUtil.getIndependenceDay(2020);

        assertEquals(testResult.getMonth(), Month.JULY);
        assertEquals(testResult.getDayOfMonth(), 3);
        assertEquals(testResult.getYear(), 2020);
    }

    @Test
    @DisplayName("getIndependenceDay - July 4th on a Sunday")
    public void fourthOnSunday(){
        final LocalDate testResult = DateUtil.getIndependenceDay(2021);

        assertEquals(testResult.getMonth(), Month.JULY);
        assertEquals(testResult.getDayOfMonth(), 5);
        assertEquals(testResult.getYear(), 2021);
    }

    @Test
    public void getLaborDay(){
        final LocalDate testResult = DateUtil.getLaborDay(2023);

        assertEquals(testResult.getMonth(), Month.SEPTEMBER);
        assertEquals(testResult.getDayOfMonth(), 4);
        assertEquals(testResult.getYear(), 2023);
    }

    @Test
    public void onOrAfterOn(){
        final LocalDate d1 = LocalDate.MIN;
        final LocalDate d2 = LocalDate.MIN;

        assert(DateUtil.onOrAfter(d1, d2));
    }

    @Test
    public void onOrAfterAfter(){
        final LocalDate d1 = LocalDate.MAX;
        final LocalDate d2 = LocalDate.MIN;

        assert(DateUtil.onOrAfter(d1, d2));
    }

    @Test
    public void onOrBeforeOn(){
        final LocalDate d1 = LocalDate.MIN;
        final LocalDate d2 = LocalDate.MIN;

        assert(DateUtil.onOrBefore(d1, d2));
    }

    @Test
    public void onOrBeforeBefore(){
        final LocalDate d1 = LocalDate.MIN;
        final LocalDate d2 = LocalDate.MAX;

        assert(DateUtil.onOrBefore(d1, d2));
    }
}
