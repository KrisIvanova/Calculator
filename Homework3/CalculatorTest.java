package org.example;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void init() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"5, 2, 7", "5, 0, 5", "-2, 6, 4", "5, -2, 3", "-5, -2, -7", "5.5, 2, 7.5"})
    public void testSummarize(double number1, double number2, double expectedResult) {
        assertEquals(expectedResult, calculator.summarize(number1, number2));
    }

    @ParameterizedTest
    @CsvSource({"5, 2, 3", "0, 2, -2", "6, 0, 6", "5, 7, -2", "-5, -2, -3", "5.5, 2, 3.5"})
    public void testSubtract(double number1, double number2, double expectedResult) {
        assertEquals(expectedResult, calculator.subtract(number1, number2));
    }

    @ParameterizedTest
    @CsvSource({"5, 2, 10", "0, 2, 0", "-5, -2, 10", "5.5, 2, 11"})
    public void testMultiply(double number1, double number2, double expectedResult) {
        assertEquals(expectedResult, calculator.multiply(number1, number2));

    }

    @ParameterizedTest
    @CsvSource({"6, 2, 3", "0, 2, 0", "11, 2, 5.5", "-10, -2, 5", "9, -3, -3"})
    public void testDivide(double number1, double number2, double expectedResult) {
        assertEquals(expectedResult, calculator.divide(number1, number2));
    }

    @ParameterizedTest
    @CsvSource({"2, 0"})
    public void testDivideByZero(double number1, double number2) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(
                        () -> calculator.divide(number1, number2)
                )
                .withMessage("can't divide by zero");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "5", "6.2", "-5.3"})
    public void testIsNumberTrue(String value) {
        assertTrue(calculator.isNumber(value), "IsNumber works incorrect for values");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "?", "пять", "\t", "\n"})
    public void testIsNumberFalse(String value) {
        assertFalse(calculator.isNumber(value), "IsNumber works incorrect for values");
    }
}



