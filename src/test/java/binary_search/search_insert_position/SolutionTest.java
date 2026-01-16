package binary_search.search_insert_position;

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
        assertEquals(2, solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    @Test
    public void testInsertAtBeginning() {
        assertEquals(0, solution.searchInsert(new int[]{2, 4, 6, 8}, 1));
    }

    @Test
    public void testInsertAtEnd() {
        assertEquals(4, solution.searchInsert(new int[]{2, 4, 6, 8}, 10));
    }

    @Test
    public void testInsertMiddle() {
        assertEquals(2, solution.searchInsert(new int[]{1, 3, 5, 6}, 4));
    }

    @Test
    public void testTargetAlreadyPresent() {
        assertEquals(3, solution.searchInsert(new int[]{1, 3, 5, 6}, 6));
    }

    @Test
    public void testSingleElementLessThanTarget() {
        assertEquals(1, solution.searchInsert(new int[]{3}, 5));
    }

    @Test
    public void testSingleElementEqualToTarget() {
        assertEquals(0, solution.searchInsert(new int[]{3}, 3));
    }

    @Test
    public void testSingleElementGreaterThanTarget() {
        assertEquals(0, solution.searchInsert(new int[]{3}, 1));
    }

    @Test
    public void testEmptyList() {
        assertEquals(0, solution.searchInsert(new int[]{}, 10));
    }
}
