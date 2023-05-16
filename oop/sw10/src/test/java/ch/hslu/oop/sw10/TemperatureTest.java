package ch.hslu.oop.sw10;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void convertCelsiusToKelvin() {
        float celsiusInKelvin = Temperature.convertCelsiusToKelvin(30f);

        assertEquals(303.15f, celsiusInKelvin);
    }

    @Test
    void convertKelvinToCelsius() {
        float kelvinInCelsius = Temperature.convertKelvinToCelsius(293.15f);

        assertEquals(20f, kelvinInCelsius);
    }

    @Test
    void getCelsius() {
        float celsius = 25f;
        Temperature temperature = new Temperature(celsius);

        float temperatureCelsius = temperature.getCelsius();

        assertEquals(celsius, temperatureCelsius);
    }

    @Test
    void setCelsius() {
        float celsius = 35f;
        Temperature temperature = new Temperature(15f);

        temperature.setCelsius(celsius);

        assertEquals(celsius, temperature.getCelsius());
    }

    @Test
    void constructor() {
        Temperature temperature1 = new Temperature(25f);

        Temperature temperature2 = new Temperature(temperature1);

        assertEquals(temperature1, temperature2);
    }

    @Test
    void compareToEquals() {
        Temperature temperature1 = new Temperature(10f);
        Temperature temperature2 = new Temperature(temperature1);

        assertEquals(0, temperature1.compareTo(temperature2));
    }

    @Test
    void compareToLower() {
        Temperature temperature1 = new Temperature(10f);
        Temperature temperature2 = new Temperature(20f);

        assertTrue(temperature1.compareTo(temperature2) < 0);
    }

    @Test
    void compareToGreater() {
        Temperature temperature1 = new Temperature(20f);
        Temperature temperature2 = new Temperature(10f);

        assertTrue(temperature1.compareTo(temperature2) > 0);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Temperature.class)
                .verify();
    }
}