package backtracking.combinations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        List<List<Integer>> expected1 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4),
                Arrays.asList(2, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 4)
        );

        assertEquals(expected1, solution.combine(4, 2));

        List<List<Integer>> expected2 = Arrays.asList(
                Arrays.asList(1)
        );

        assertEquals(expected2, solution.combine(1, 1));
    }

    @Test
    public void testKEqualsZero() {
        List<List<Integer>> expected = Arrays.asList(
                Collections.emptyList()
        );

        assertEquals(expected, solution.combine(5, 0));
    }

    @Test
    public void testKGreaterThanN() {
        assertEquals(Collections.emptyList(), solution.combine(3, 4));
    }

    @Test
    public void testNEqualsZero() {
        List<List<Integer>> expected = Arrays.asList(
                Collections.emptyList()
        );

        assertEquals(expected, solution.combine(0, 0));
        assertEquals(Collections.emptyList(), solution.combine(0, 1));
    }

    @Test
    public void testNEqualsK() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3)
        );

        assertEquals(expected, solution.combine(3, 3));
    }

    @Test
    public void testLargeInput() {
        List<List<Integer>> result = solution.combine(5, 3);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 4),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 3, 4),
                Arrays.asList(1, 3, 5),
                Arrays.asList(1, 4, 5),
                Arrays.asList(2, 3, 4),
                Arrays.asList(2, 3, 5),
                Arrays.asList(2, 4, 5),
                Arrays.asList(3, 4, 5)
        );

        assertEquals(expected, result);
    }
}
