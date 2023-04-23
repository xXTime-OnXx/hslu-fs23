package ch.hslu.oop.sw09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class TemperatureCourse {

    private final List<Temperature> temperatureList = new ArrayList<>();

    public TemperatureCourse() {
    }

    public void add(Temperature temperature) {
        temperatureList.add(temperature);
    }

    public int getCount() {
        return temperatureList.size();
    }

    public void clear() {
        temperatureList.clear();
    }

    public Temperature max() {
        return Collections.max(temperatureList);
    }

    public Temperature min() {
        return Collections.min(temperatureList);
    }

    public Temperature avg() {
        float averageCelsius = (float) temperatureList.stream()
                .map(Temperature::getCelsius)
                .mapToDouble(celsius -> celsius)
                .average()
                .orElseThrow(NoSuchElementException::new);
        return new Temperature(averageCelsius);
    }
}
