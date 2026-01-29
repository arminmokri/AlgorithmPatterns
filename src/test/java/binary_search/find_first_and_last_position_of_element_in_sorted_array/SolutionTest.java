package binary_search.find_first_and_last_position_of_element_in_sorted_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertArrayEquals(
                new int[]{3, 4},
                solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)
        );

        assertArrayEquals(
                new int[]{-1, -1},
                solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)
        );

        assertArrayEquals(
                new int[]{0, 0},
                solution.searchRange(new int[]{1}, 1)
        );
    }

    @Test
    public void testTargetAtBeginning() {
        assertArrayEquals(
                new int[]{0, 1},
                solution.searchRange(new int[]{2, 2, 3, 4, 5}, 2)
        );
    }

    @Test
    public void testTargetAtEnd() {
        assertArrayEquals(
                new int[]{3, 4},
                solution.searchRange(new int[]{1, 2, 3, 4, 4}, 4)
        );
    }

    @Test
    public void testAllElementsSameAsTarget() {
        assertArrayEquals(
                new int[]{0, 4},
                solution.searchRange(new int[]{7, 7, 7, 7, 7}, 7)
        );
    }

    @Test
    public void testAllElementsSameButNotTarget() {
        assertArrayEquals(
                new int[]{-1, -1},
                solution.searchRange(new int[]{3, 3, 3, 3}, 2)
        );
    }

    @Test
    public void testEmptyArray() {
        assertArrayEquals(
                new int[]{-1, -1},
                solution.searchRange(new int[]{}, 5)
        );
    }

    @Test
    public void testSingleElementNotTarget() {
        assertArrayEquals(
                new int[]{-1, -1},
                solution.searchRange(new int[]{1}, 2)
        );
    }

    @Test
    public void testMultipleOccurrencesInMiddle() {
        assertArrayEquals(
                new int[]{2, 4},
                solution.searchRange(new int[]{1, 2, 3, 3, 3, 4, 5}, 3)
        );
    }

    @Test
    public void testNegativeNumbers() {
        assertArrayEquals(
                new int[]{1, 3},
                solution.searchRange(new int[]{-5, -3, -3, -3, 0, 2}, -3)
        );
    }

    @Test
    public void testTargetLessThanAllElements() {
        assertArrayEquals(
                new int[]{-1, -1},
                solution.searchRange(new int[]{5, 6, 7, 8}, 1)
        );
    }

    @Test
    public void testTargetGreaterThanAllElements() {
        assertArrayEquals(
                new int[]{-1, -1},
                solution.searchRange(new int[]{5, 6, 7, 8}, 10)
        );
    }
}
