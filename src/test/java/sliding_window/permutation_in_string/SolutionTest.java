package sliding_window.permutation_in_string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertTrue(solution.checkInclusion("ab", "eidbaooo"));
        assertFalse(solution.checkInclusion("ab", "eidboaoo"));
    }

    @Test
    public void testEmptyStrings() {
        assertTrue(solution.checkInclusion("", ""));
        assertTrue(solution.checkInclusion("", "abc"));
        assertFalse(solution.checkInclusion("a", ""));
    }

    @Test
    public void testExactMatch() {
        assertTrue(solution.checkInclusion("abc", "abc"));
    }

    @Test
    public void testNoMatch() {
        assertFalse(solution.checkInclusion("abc", "defghijk"));
    }

    @Test
    public void testMultipleOccurrences() {
        assertTrue(solution.checkInclusion("abc", "defbacghiabc"));
        assertTrue(solution.checkInclusion("abc", "zzzcbazzz"));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(solution.checkInclusion("a", "a"));
        assertTrue(solution.checkInclusion("a", "xyzabc"));
        assertFalse(solution.checkInclusion("z", "abcabc"));
    }

    @Test
    public void testCaseSensitivity() {
        assertTrue(solution.checkInclusion("a", "Aabc"));
        assertFalse(solution.checkInclusion("ab", "AB"));
    }

    @Test
    public void testLongStrings() {
        String s1 = "abc";
        String s2 = "x".repeat(1000) + "cab" + "y".repeat(1000);
        assertTrue(solution.checkInclusion(s1, s2));
    }
}
