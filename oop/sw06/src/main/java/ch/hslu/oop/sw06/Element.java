package ch.hslu.oop.sw06;

public abstract class Element {

    private String elementCode;
    private double meltingTemperatureCelsius;
    private double boilingTemperatureCelsius;

    public Element(String elementCode, double meltingTemperatureCelsius, double boilingTemperatureCelsius) {
        this.elementCode = elementCode;
        this.meltingTemperatureCelsius = meltingTemperatureCelsius;
        this.boilingTemperatureCelsius = boilingTemperatureCelsius;
    }

    public AggregateState getAggregateState(double temperature) {
        if (temperature <= meltingTemperatureCelsius) {
            return AggregateState.SOLID;
        } else if (temperature >= boilingTemperatureCelsius) {
            return AggregateState.GAS;
        } else {
            return AggregateState.LIQUID;
        }
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
