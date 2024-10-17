import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void testCelsiusToFahrenheit_zeroDegrees() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.001, "0°C should convert to 32°F");
    }

    @Test
    void testCelsiusToFahrenheit_boilingPoint() {
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.001, "100°C should convert to 212°F");
    }

    @Test
    void testCelsiusToFahrenheit_freezingPoint() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.001, "0°C should convert to 32°F");
    }

    @Test
    void testCelsiusToFahrenheit_negativeCelsius() {
        assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.001, "-40°C should convert to -40°F");
    }

    @Test
    void testFahrenheitToCelsius_freezingPoint() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.001, "32°F should convert to 0°C");
    }

    @Test
    void testFahrenheitToCelsius_boilingPoint() {
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.001, "212°F should convert to 100°C");
    }

    @Test
    void testFahrenheitToCelsius_negativeFahrenheit() {
        assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.001, "-40°F should convert to -40°C");
    }

    @Test
    void testFahrenheitToCelsius_belowFreezing() {
        assertEquals(-17.7778, converter.fahrenheitToCelsius(0), 0.001, "0°F should convert to -17.78°C");
    }

    @Test
    void testInvalidInputForCelsiusToFahrenheit() {
        // Here you can either throw an exception for invalid input or test for unexpected results.
        // Let's assume we allow any double input and test for NaN handling.
        assertThrows(NumberFormatException.class, () -> {
            converter.celsiusToFahrenheit(Double.parseDouble("invalid"));
        });
    }

    @Test
    void testInvalidInputForFahrenheitToCelsius() {
        assertThrows(NumberFormatException.class, () -> {
            converter.fahrenheitToCelsius(Double.parseDouble("invalid"));
        });
    }
}
