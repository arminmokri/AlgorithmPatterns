package dynamic_programming.edit_distance;

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
        assertEquals(3, solution.minDistance("horse", "ros"));
        assertEquals(5, solution.minDistance("intention", "execution"));
    }

    @Test
    public void testEmptyStrings() {
        assertEquals(0, solution.minDistance("", ""));
    }

    @Test
    public void testOneEmptyOneNonEmpty() {
        assertEquals(3, solution.minDistance("", "abc"));
        assertEquals(4, solution.minDistance("test", ""));
    }

    @Test
    public void testIdenticalStrings() {
        assertEquals(0, solution.minDistance("algorithm", "algorithm"));
    }

    @Test
    public void testSingleCharacterDifferences() {
        assertEquals(1, solution.minDistance("a", "b"));
        assertEquals(1, solution.minDistance("a", ""));
        assertEquals(1, solution.minDistance("", "a"));
    }

    @Test
    public void testInsertionOnly() {
        assertEquals(2, solution.minDistance("cat", "catch"));
    }

    @Test
    public void testDeletionOnly() {
        assertEquals(2, solution.minDistance("house", "hou"));
    }

    @Test
    public void testReplacementOnly() {
        assertEquals(3, solution.minDistance("abc", "xyz"));
    }

    @Test
    public void testMixedOperations() {
        assertEquals(2, solution.minDistance("flaw", "lawn"));
    }

    @Test
    public void testRepeatedCharacters() {
        assertEquals(2, solution.minDistance("aaaa", "aa"));
    }

    @Test
    public void testCaseSensitivity() {
        assertEquals(1, solution.minDistance("Apple", "apple"));
    }

    @Test
    public void testLongerStrings() {
        assertEquals(5, solution.minDistance("distance", "editing"));
    }

    @Test
    public void testVeryLargeStrings_DPRequired() {
        String s1 = "a".repeat(500) + "b".repeat(500);
        String s2 = "a".repeat(500) + "c".repeat(500);

        // Only last 500 characters differ (b -> c)
        // Optimal edit distance = 500 replacements
        assertEquals(500, solution.minDistance(s1, s2));
    }
}
