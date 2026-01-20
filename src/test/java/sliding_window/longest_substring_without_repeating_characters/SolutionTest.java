package sliding_window.longest_substring_without_repeating_characters;

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
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, solution.lengthOfLongestSubstring(""));
    }

    @Test
    public void testAllUnique() {
        assertEquals(6, solution.lengthOfLongestSubstring("abcdef"));
    }

    @Test
    public void testAllSameChar() {
        assertEquals(1, solution.lengthOfLongestSubstring("aaaaaa"));
    }

    @Test
    public void testSubstringAtEnd() {
        assertEquals(7, solution.lengthOfLongestSubstring("abcdeabcdefg"));
    }

    @Test
    public void testNumbersAndSymbols() {
        assertEquals(13, solution.lengthOfLongestSubstring("1234567890!@#"));
    }

    @Test
    public void testRepeatingPatterns() {
        assertEquals(2, solution.lengthOfLongestSubstring("abababab"));
    }

    @Test
    public void testMixedCase() {
        assertEquals(6, solution.lengthOfLongestSubstring("aAbBcC"));
    }

    @Test
    public void testUnicode() {
        assertEquals(2, solution.lengthOfLongestSubstring("🙂🙃🙂🙃"));
    }
}
