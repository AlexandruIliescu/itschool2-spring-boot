package ro.itschool.project.unit_tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ro.itschool.project.utils.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAddition_WithValidInput_ShouldPass() {
        //given
        int a = 5;
        int b = 24;
        int expectedResult = a + b;

        //when
        int actualResult = calculator.add(a, b);

        //then
        assertEquals(expectedResult, actualResult, "The addition result should be equal to the expected result.");
    }

    @Test
    void testAddition_WithResultExceedsMaximumIntegerValue_ShouldFail() {
        //given
        int a = Integer.MAX_VALUE;
        int b = 1;
        long expectedResult = (long) a + b;

        //when
        int actualResult = calculator.add(a, b);

        //then
        assertNotEquals(expectedResult, actualResult);
    }
}