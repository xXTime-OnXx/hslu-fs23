package ch.hslu.oop.sw07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void testDifferentShapes() {
        Shape shape1 = new Circle(4, 5, 10);
        Shape shape2 = new Rectangle(-2, 3, 7, 4);

        shape1.move(1, 1);
        shape2.move(1, 1);

        int diameter = ((Circle) shape1).getDiameter();

        assertTrue(true);
    }

}