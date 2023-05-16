package ch.hslu.oop.sw10;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureCourseTest {

    @Test
    void add() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(20f);

        temperatureCourse.add(temperature);

        assertEquals(1, temperatureCourse.getCount());
    }

    @Test
    void getCount() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(20f);

        temperatureCourse.add(temperature);
        temperatureCourse.add(temperature);

        assertEquals(2, temperatureCourse.getCount());
    }

    @Test
    void clear() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(20f);
        temperatureCourse.add(temperature);
        temperatureCourse.add(temperature);

        temperatureCourse.clear();

        assertEquals(0, temperatureCourse.getCount());
    }

    @Test
    void max() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature highestTemperature = new Temperature(40f);
        temperatureCourse.add(new Temperature(20f));
        temperatureCourse.add(highestTemperature);
        temperatureCourse.add(highestTemperature);
        temperatureCourse.add(new Temperature(30f));

        Temperature maxTemperature = temperatureCourse.max();

        assertEquals(highestTemperature, maxTemperature);
    }

    @Test
    void min() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature lowestTemperature = new Temperature(-10f);
        temperatureCourse.add(new Temperature(20f));
        temperatureCourse.add(lowestTemperature);
        temperatureCourse.add(new Temperature(30f));
        temperatureCourse.add(lowestTemperature);

        Temperature minTemperature = temperatureCourse.min();

        assertEquals(lowestTemperature, minTemperature);
    }

    @Test
    void average() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        temperatureCourse.add(new Temperature(15f));
        temperatureCourse.add(new Temperature(25f));

        Temperature averageTemperature = temperatureCourse.avg();

        assertEquals(20f, averageTemperature.getCelsius());
    }

    @Test
    void emptyListOperations() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();

        assertThrows(NoSuchElementException.class, temperatureCourse::max);
        assertThrows(NoSuchElementException.class, temperatureCourse::min);
        assertThrows(NoSuchElementException.class, temperatureCourse::avg);
    }

}