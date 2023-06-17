package hw;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathLibraryTest {
    @Test
    public void testSquareRoot() {
        assertEquals(2.0, MathLibrary.squareRoot(4.0));
    }

    @Test
    public void testCalculateAverage() {
        double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertEquals(3.0, MathLibrary.calculateAverage(numbers));
    }

    @Test
    public void testFindMax() {
        int[] numbers = {5, 8, 2, 10, 3};
        assertEquals(10, MathLibrary.findMax(numbers));
    }

    @Test
    public void testIsPrime() {
        assertFalse(MathLibrary.isPrime(1));
        assertTrue(MathLibrary.isPrime(2));
        assertTrue(MathLibrary.isPrime(3));
        assertFalse(MathLibrary.isPrime(4));
        assertTrue(MathLibrary.isPrime(17));
        assertFalse(MathLibrary.isPrime(20));
    }
}

