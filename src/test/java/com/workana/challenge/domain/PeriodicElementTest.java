package com.workana.challenge.domain;

import com.workana.challenge.junit.AbstractIntegrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by: Elvis Ribeiro
 */
class PeriodicElementTest extends AbstractIntegrationTest {

    @Test
    @DisplayName("Test map for Periodic Element")
    void testSymbolAsMapValue() {
        var map = PeriodicElement.map();
        assertEquals(118, map.size());
        assertEquals(PeriodicElement.CURIUM, map.get("Cm"));
    }

}