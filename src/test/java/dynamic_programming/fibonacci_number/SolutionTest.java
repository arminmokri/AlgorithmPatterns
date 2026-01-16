package dynamic_programming.fibonacci_number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertEquals(0, solution.fibonacciNumber(0));
        assertEquals(1, solution.fibonacciNumber(1));
        assertEquals(1, solution.fibonacciNumber(2));
        assertEquals(2, solution.fibonacciNumber(3));
        assertEquals(3, solution.fibonacciNumber(4));
    }

    @Test
    public void testFibZero() {
        assertEquals(0, solution.fibonacciNumber(0));
    }

    @Test
    public void testFibOne() {
        assertEquals(1, solution.fibonacciNumber(1));
    }

    @Test
    public void testFibTwo() {
        assertEquals(1, solution.fibonacciNumber(2));
    }

    @Test
    public void testFibFive() {
        assertEquals(5, solution.fibonacciNumber(5));
    }

    @Test
    public void testFibTen() {
        assertEquals(55, solution.fibonacciNumber(10));
    }

    @Test
    public void testFibLarge() {
        assertEquals(139583862445L, solution.fibonacciNumber(55));
    }
}
