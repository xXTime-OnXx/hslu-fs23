package ch.hslu.oop.sw09;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature> {

    private static final float KELVIN_OFFSET = 273.15f;
    private float kelvin;

    public Temperature(float celsius) {
        setCelsius(celsius);
    }

    public Temperature(Temperature temperature) {
        kelvin = temperature.getKelvin();
    }

    public static float convertCelsiusToKelvin(float celsius) {
        return KELVIN_OFFSET + celsius;
    }

    public static float convertKelvinToCelsius(float kelvin) {
        return kelvin - KELVIN_OFFSET;
    }

    public float getKelvin() {
        return kelvin;
    }

    public void setKelvin(float kelvin) {
        this.kelvin = kelvin;
    }

    public float getCelsius() {
        return convertKelvinToCelsius(kelvin);
    }

    public void setCelsius(float celsius) {
        kelvin = convertCelsiusToKelvin(celsius);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "kelvin=" + kelvin +
                "celsius=" + getCelsius() +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Temperature that)) return false;
        return Float.compare(kelvin, that.kelvin) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kelvin);
    }

    @Override
    public int compareTo(Temperature other) {
        return Float.compare(kelvin, other.kelvin);
    }
}
