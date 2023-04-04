package ch.hslu.oop.sw03;

public class Element {
    private String elementCode;
    private double meltingTemperatureCelsius;
    private double boilingTemperatureCelsius;

    public Element(String elementCode, int meltingTemperatureCelsius, int boilingTemperatureCelsius) {
        this.elementCode = elementCode;
        this.meltingTemperatureCelsius = meltingTemperatureCelsius;
        this.boilingTemperatureCelsius = boilingTemperatureCelsius;
    }

    public double getMeltingTemperatureCelsius() {
        return this.meltingTemperatureCelsius;
    }

    public double getBoilingTemperatureCelsius() {
        return boilingTemperatureCelsius;
    }

}
