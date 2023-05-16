package ch.hslu.oop.sw10;

public enum AggregateState {
    SOLID("solid"),
    LIQUID("liquid"),
    GAS("gas");

    private final String value;

    AggregateState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}