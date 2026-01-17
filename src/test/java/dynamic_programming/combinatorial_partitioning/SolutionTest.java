package dynamic_programming.combinatorial_partitioning;

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
        assertEquals(5, solution.combinatorialPartitioning(2, 8));
    }

    @Test
    public void testZeroTotal() {
        assertEquals(1, solution.combinatorialPartitioning(5, 0));
    }

    @Test
    public void testZeroRange() {
        assertEquals(0, solution.combinatorialPartitioning(0, 5));
    }

    @Test
    public void testEqualRAndTotal() {
        assertEquals(5, solution.combinatorialPartitioning(4, 4));
    }

    @Test
    public void testOneStepOnly() {
        assertEquals(1, solution.combinatorialPartitioning(1, 5));
    }

    @Test
    public void testTotalLessThanR() {
        assertEquals(3, solution.combinatorialPartitioning(10, 3));
    }

    @Test
    public void testLargeTotal() {
        assertEquals(14, solution.combinatorialPartitioning(3, 10));
    }

    @Test
    public void testHugeCase_naiveRecursionWillTimeOutOrStackOverflow() {
        assertEquals(189477547, solution.combinatorialPartitioning(50, 100));
    }

}
