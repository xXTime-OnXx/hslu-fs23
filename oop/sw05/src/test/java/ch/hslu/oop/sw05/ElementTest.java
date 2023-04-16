package ch.hslu.oop.sw05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static ch.hslu.oop.sw05.AggregateState.*;
import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @ParameterizedTest
    @MethodSource("provideElementAggregateStateArguments")
    void testGetAggregateState(Class<? extends Element> elementClass, double temperature,
                               AggregateState expectedAggregateState)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Element element = elementClass.getConstructor().newInstance();

        AggregateState elementAggregateState = element.getAggregateState(temperature);

        assertEquals(expectedAggregateState, elementAggregateState);
    }

    private static Stream<Arguments> provideElementAggregateStateArguments() {
        return Stream.of(
                Arguments.of(Oxygen.class, 0, GAS),
                Arguments.of(Oxygen.class, -195, LIQUID),
                Arguments.of(Oxygen.class, -220, SOLID),
                Arguments.of(Hydrogen.class, 0, GAS),
                Arguments.of(Hydrogen.class, -254, LIQUID),
                Arguments.of(Hydrogen.class, -260, SOLID)
        );
    }

}