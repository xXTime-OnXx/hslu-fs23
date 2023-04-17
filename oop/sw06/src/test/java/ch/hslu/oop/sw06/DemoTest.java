package ch.hslu.oop.sw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoTest {

    @Test
    void maxWith3ParameterShouldReturnFirstParameter() {
        Demo demo = new Demo();

        int max = demo.max(5, 4, 3);

        assertEquals(5, max);
    }

    @Test
    void maxWith3ParameterShouldReturnSecondParameter() {
        Demo demo = new Demo();

        int max = demo.max(4, 6, 3);

        assertEquals(6, max);
    }

    @Test
    void maxWith3ParameterShouldReturnThirdParameter() {
        Demo demo = new Demo();

        int max = demo.max(4, 2, 8);

        assertEquals(8, max);
    }
}