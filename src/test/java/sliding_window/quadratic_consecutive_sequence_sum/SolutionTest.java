package sliding_window.quadratic_consecutive_sequence_sum;

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
        assertEquals(
                "[\"count: 2\", \"21 22 23 24\", \"25 26 27\"]",
                solution.quadraticConsecutiveSequenceSum(2030)
        );
        assertEquals(
                "[\"count: 1\", \"3 4 5\"]",
                solution.quadraticConsecutiveSequenceSum(50)
        );
        assertEquals(
                "[\"count: 2\", \"10 11 12\", \"13 14\"]",
                solution.quadraticConsecutiveSequenceSum(365)
        );
    }

    @Test
    public void testSingleTerm() {
        assertEquals(
                "[\"count: 1\", \"7\"]",
                solution.quadraticConsecutiveSequenceSum(49)
        );
    }

    @Test
    public void testTwoTermSequence() {
        assertEquals(
                "[\"count: 1\", \"8 9\"]",
                solution.quadraticConsecutiveSequenceSum(145)
        );
    }

    @Test
    public void testLargerSum() {
        assertEquals(
                "[\"count: 2\", \"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24\", \"70\"]",
                solution.quadraticConsecutiveSequenceSum(4900)
        );
    }

    @Test
    public void testNoSequencePossible() {
        assertEquals(
                "[\"count: 0\"]",
                solution.quadraticConsecutiveSequenceSum(997)
        );
    }

    @Test
    public void testMinValue() {
        assertEquals(
                "[\"count: 1\", \"1\"]",
                solution.quadraticConsecutiveSequenceSum(1)
        );
    }

    @Test
    public void testNonContiguousPotentialConfusion() {
        assertEquals(
                "[\"count: 1\", \"6 7\"]",
                solution.quadraticConsecutiveSequenceSum(85)
        );
    }
}
