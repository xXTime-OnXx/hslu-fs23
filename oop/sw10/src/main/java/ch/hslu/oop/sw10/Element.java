package ch.hslu.oop.sw10;

import java.util.Objects;

public abstract class Element {

    private final String elementCode;
    private final double meltingTemperatureCelsius;
    private final double boilingTemperatureCelsius;

    public Element(String elementCode, double meltingTemperatureCelsius, double boilingTemperatureCelsius) {
        this.elementCode = elementCode;
        this.meltingTemperatureCelsius = meltingTemperatureCelsius;
        this.boilingTemperatureCelsius = boilingTemperatureCelsius;
    }

    public AggregateState getAggregateState(Temperature temperature) {
        if (temperature.getCelsius() <= meltingTemperatureCelsius) {
            return AggregateState.SOLID;
        } else if (temperature.getCelsius() >= boilingTemperatureCelsius) {
            return AggregateState.GAS;
        }
        return AggregateState.LIQUID;
    }

    public String toElementState(Temperature temperature) {
        return this.getClass().getSimpleName() + " " +
                "is " + getAggregateState(temperature) + " " +
                "at " + temperature.getCelsius() + "°C";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element element)) return false;
        return Double.compare(element.meltingTemperatureCelsius, meltingTemperatureCelsius) == 0 &&
                Double.compare(element.boilingTemperatureCelsius, boilingTemperatureCelsius) == 0 &&
                Objects.equals(elementCode, element.elementCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementCode, meltingTemperatureCelsius, boilingTemperatureCelsius);
    }

    @Override
    public String toString() {
        return "Element{" +
                "elementCode='" + elementCode + '\'' +
                ", meltingTemperatureCelsius=" + meltingTemperatureCelsius +
                ", boilingTemperatureCelsius=" + boilingTemperatureCelsius +
                '}';
    }
}
