package ch.hslu.oop.sw09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @Test
    void toElementState() {
        Lead lead = new Lead();
        Temperature twentyDegreesCelsius = new Temperature(20f);

        assertEquals(
                "Lead is solid at 20.0°C",
                lead.toElementState(twentyDegreesCelsius)
        );
    }

}