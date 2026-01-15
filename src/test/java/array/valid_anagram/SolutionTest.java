package array.valid_anagram;

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
        assertTrue(solution.isAnagram("listen", "silent"));
    }

    @Test
    public void testTrueCase() {
        assertTrue(solution.isAnagram("listen", "silent"));
        assertTrue(solution.isAnagram("triangle", "integral"));
        assertTrue(solution.isAnagram("aabbcc", "abcabc"));
    }

    @Test
    public void testFalseCase() {
        assertFalse(solution.isAnagram("hello", "bello"));
        assertFalse(solution.isAnagram("rat", "car"));
        assertFalse(solution.isAnagram("aabb", "aabbb"));
    }

    @Test
    public void testCaseSensitive() {
        assertFalse(solution.isAnagram("Listen", "silent"));
    }

    @Test
    public void testEmptyStrings() {
        assertTrue(solution.isAnagram("", ""));
        assertFalse(solution.isAnagram("abc", ""));
        assertFalse(solution.isAnagram("", "abc"));
    }

    @Test
    public void testSameLettersDifferentLengths() {
        assertFalse(solution.isAnagram("aabbcc", "abc"));
        assertFalse(solution.isAnagram("abc", "aabbcc"));
    }

    @Test
    public void testUnicodeSupport() {
        assertTrue(solution.isAnagram("éàè", "èàé"));
    }
}
