package org.example.ra0824.model.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ToolUnitTest {
    @Test
    @DisplayName("Tool.fromCode() ignores case")
    public void fromCodeIgnoresCase() {
        Tool testResult = Tool.fromCode("ChNs");
        assertEquals(testResult, Tool.CHAINSAW_STIHL);
    }

    @Test
    @DisplayName("Tool.fromCode() returns null when none found")
    public void fromCodeReturnsNullWhenNoneFound() {
        Tool testResult = Tool.fromCode("foobar");
        assertNull(testResult);
    }
}
