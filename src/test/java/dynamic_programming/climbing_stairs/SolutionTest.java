package dynamic_programming.climbing_stairs;

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
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
    }

    @Test
    public void testMinNumber() {
        assertEquals(1, solution.climbStairs(1));
    }

    @Test
    public void testBigNumber() {
        assertEquals(20365011074L, solution.climbStairs(50));
    }
}
