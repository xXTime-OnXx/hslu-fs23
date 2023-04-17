package ch.hslu.oop.sw07;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("provideAdditionArguments")
    void add(int firstNumber, int secondNumber, int expectedSum) {
        ICalculator calculator = new Calculator();

        int sum = calculator.add(firstNumber, secondNumber);

        assertEquals(expectedSum, sum);
    }

    private static Stream<Arguments> provideAdditionArguments() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 1, 1),
                Arguments.of(1, 0, 1),
                Arguments.of(2, 0, 2),
                Arguments.of(2, 1, 3),
                Arguments.of(2, -1, 1),
                Arguments.of(-2, -1, -3)
        );
    }
}