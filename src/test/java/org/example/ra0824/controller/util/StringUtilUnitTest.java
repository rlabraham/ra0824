package org.example.ra0824.controller.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class StringUtilUnitTest {
    @Test
    public void formatAmountUSCurrency() {
        assertEquals(StringUtil.formatAmountUSCurrency(12345.678), "$12,345.68");
    }

    @Test
    public void formatPercent() {
        assertEquals(StringUtil.formatPercent(123), "123%");
    }

}
