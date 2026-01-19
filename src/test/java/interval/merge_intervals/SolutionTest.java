package interval.merge_intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        assertEquals(
                Arrays.asList(Arrays.asList(1, 6), Arrays.asList(8, 10), Arrays.asList(15, 18)),
                solution.merge(Arrays.asList(
                        Arrays.asList(1, 3),
                        Arrays.asList(2, 6),
                        Arrays.asList(8, 10),
                        Arrays.asList(15, 18)
                ))
        );

        assertEquals(
                Arrays.asList(Arrays.asList(1, 5)),
                solution.merge(Arrays.asList(
                        Arrays.asList(1, 4),
                        Arrays.asList(4, 5)
                ))
        );
    }

    @Test
    public void testMergeNestedIntervals() {
        assertEquals(
                Arrays.asList(Arrays.asList(1, 7)),
                solution.merge(Arrays.asList(
                        Arrays.asList(1, 7),
                        Arrays.asList(2, 6),
                        Arrays.asList(3, 5)
                ))
        );

        assertEquals(
                Arrays.asList(Arrays.asList(1, 7)),
                solution.merge(Arrays.asList(
                        Arrays.asList(2, 6),
                        Arrays.asList(3, 5),
                        Arrays.asList(1, 7)
                ))
        );
    }

    @Test
    public void testMergeEdgeTouching() {
        assertEquals(
                Arrays.asList(Arrays.asList(1, 4)),
                solution.merge(Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(2, 3),
                        Arrays.asList(3, 4)
                ))
        );
    }

    @Test
    public void testMergeNonOverlapping() {
        assertEquals(
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6)),
                solution.merge(Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(3, 4),
                        Arrays.asList(5, 6)
                ))
        );
    }

    @Test
    public void testMergeSingleInterval() {
        assertEquals(
                Arrays.asList(Arrays.asList(1, 10)),
                solution.merge(Arrays.asList(Arrays.asList(1, 10)))
        );
    }

    @Test
    public void testMergeEmptyList() {
        assertEquals(
                List.of(),
                solution.merge(List.of())
        );
    }
}
