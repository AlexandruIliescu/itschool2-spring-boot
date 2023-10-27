package ro.itschool.project.unit_tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ro.itschool.project.utils.Greeter;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

    private static Greeter greeter;

    @BeforeAll
    static void setup() {
        greeter = new Greeter();
    }

    @Test
    void testGenerateGreetingMessageShouldPass() {
        assertEquals("Hello, John!", greeter.greet("John"));
    }

    @Test
    void testGenerateGreetingMessageWithSpacesShouldPass() {
        assertNotEquals("Hello, John!", greeter.greet("      John"));
    }

    @Test
    void testGenerateGreetingMessageWithEmptyNameShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> greeter.greet(""));
    }

    @Test
    void testGenerateGreetingMessageWithNullNameShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> greeter.greet(null));
    }
}