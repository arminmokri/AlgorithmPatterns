package array.longest_common_prefix;

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
                "fl",
                solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"})
        );

        assertEquals(
                "",
                solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"})
        );
    }

    @Test
    public void testSingleWord() {
        assertEquals(
                "alone",
                solution.longestCommonPrefix(new String[]{"alone"})
        );
    }

    @Test
    public void testIdenticalWords() {
        assertEquals(
                "same",
                solution.longestCommonPrefix(new String[]{"same", "same", "same"})
        );
    }

    @Test
    public void testEmptyList() {
        assertEquals(
                "",
                solution.longestCommonPrefix(new String[]{})
        );
    }

    @Test
    public void testListWithEmptyString() {
        assertEquals(
                "",
                solution.longestCommonPrefix(new String[]{"", "abc", "ab"})
        );
    }

    @Test
    public void testNoCommonPrefix() {
        assertEquals(
                "",
                solution.longestCommonPrefix(new String[]{"abc", "def", "ghi"})
        );
    }

    @Test
    public void testFullPrefixMatch() {
        assertEquals(
                "inter",
                solution.longestCommonPrefix(
                        new String[]{"interview", "intervene", "internal"}
                )
        );
    }

    @Test
    public void testNumericStringPrefix() {
        assertEquals(
                "123",
                solution.longestCommonPrefix(
                        new String[]{"12345", "123", "123abc"}
                )
        );
    }

    @Test
    public void testCaseSensitive() {
        assertEquals(
                "",
                solution.longestCommonPrefix(
                        new String[]{"Case", "case", "cast"}
                )
        );
    }
}
