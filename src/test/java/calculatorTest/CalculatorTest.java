package calculatorTest;

import org.hillel.calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    public static void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test to verify square of number 5")
    public void testSquare() {
        int result = calculator.square(5);
        Assertions.assertEquals(25, result, "Result is wrong: " + result);
    }

    @Test
    @DisplayName("Test to verify division of number 10 and 5")
    public void testDivision() {
        int result = calculator.division(10, 5);
        Assertions.assertEquals(2, result, "Result is wrong: " + result);
    }

    @Test
    @DisplayName("Test to verify multiply of number 2, 4 and 3")
    public void testMultiply() {
        int result = calculator.multiply(2, 4, 3);
        Assertions.assertEquals(24, result, "Result is wrong:" + result);
    }

    @Test
    @DisplayName("Test to verify subtraction of number 4 and 4")
    public void testSubtraction() {
        int result = calculator.subtraction(4, 4);
        Assertions.assertTrue(result == 0, "Result is wrong: " + result);
    }

    @ParameterizedTest
    @DisplayName("Test to verify square with Parameters")
    @ValueSource(ints = {5, 3, 7})
    public void testSquareWithParameters(int a) {
        int result = calculator.square(a);
        Assertions.assertTrue(result > 5, "Result is wrong: " + result);
    }

    @ParameterizedTest
    @DisplayName("Test to verify subtraction with parameters")
    @MethodSource("integerStreamNumbers")
    public void testSubtractionWithParameters(int a, int b, int expected) {
        int result = calculator.subtraction(a, b);
        Assertions.assertEquals(result, expected, "Result is wrong: " + result);
    }

    public static Stream<Arguments> integerStreamNumbers() {
        return Stream.of(
                Arguments.arguments(15, 5, 10),
                Arguments.arguments(3, 2, 1),
                Arguments.arguments(7, 4, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 3, 7})
    public void testSubtractionWithOneParameter(int a) {
        int result = calculator.subtraction(a, 4);
        Assertions.assertFalse(result == 0, "Result is wrong: " + result);
    }
}
