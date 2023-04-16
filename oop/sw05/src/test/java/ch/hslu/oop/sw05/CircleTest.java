package ch.hslu.oop.sw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    public static final int DIAMETER = 4;
    public static final int PERIMETER = 12;
    public static final int AREA = 12;

    @Test
    void getDiameterShouldReturnDiameter() {
        Circle circle = new Circle(1, 2, DIAMETER);

        int circleDiameter = circle.getDiameter();

        assertEquals(DIAMETER, circleDiameter);
    }

    @Test
    void getPerimeter() {
        Circle circle = new Circle(1, 2, DIAMETER);

        int circlePerimeter = circle.getPerimeter();

        assertEquals(PERIMETER, circlePerimeter);
    }

    @Test
    void getArea() {
        Circle circle = new Circle(1, 2, DIAMETER);

        int circleArea = circle.getArea();

        assertEquals(AREA, circleArea);
    }
}