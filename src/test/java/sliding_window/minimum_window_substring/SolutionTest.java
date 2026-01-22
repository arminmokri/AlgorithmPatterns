package sliding_window.minimum_window_substring;

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
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", solution.minWindow("a", "a"));
        assertEquals("", solution.minWindow("a", "aa"));
    }

    @Test
    public void testMinWindow_TargetLongerThanSource_ReturnsEmpty() {
        assertEquals("", solution.minWindow("ab", "abc"));
    }

    @Test
    public void testMinWindow_TargetContainsMissingCharacter_ReturnsEmpty() {
        assertEquals("", solution.minWindow("aabbcc", "aabbccd"));
    }

    @Test
    public void testMinWindow_TargetHasDuplicates_Basic() {
        assertEquals("AABBC", solution.minWindow("ZAABBCY", "AABC"));
    }

    @Test
    public void testMinWindow_TargetHasDuplicates_NoSolution() {
        assertEquals("", solution.minWindow("ABBC", "AABC"));
    }

    @Test
    public void testMinWindow_AllCharactersSame_ExactMatch() {
        assertEquals("aaaa", solution.minWindow("aaaa", "aaaa"));
    }

    @Test
    public void testMinWindow_AllCharactersSame_MinimalSubstring() {
        assertEquals("aaa", solution.minWindow("aaaaa", "aaa"));
    }

    @Test
    public void testMinWindow_MultiplePossibleWindows_PicksShortest() {
        // Two possible windows "ABBC" and "BCA"; shortest is "BCA"
        assertEquals("BCA", solution.minWindow("ABBCA", "BCA"));
    }

    @Test
    public void testMinWindow_MultipleShortestWindows_ReturnsFirstMinimal() {
        // Minimal windows of length 3: "BAC" (index 1..3) and "ACB" (index 3..5)
        // Typical implementations return the first encountered minimal window.
        assertEquals("BAC", solution.minWindow("ABACB", "ABC"));
    }

    @Test
    public void testMinWindow_WindowAtStart() {
        assertEquals("ABC", solution.minWindow("ABCZZZ", "ABC"));
    }

    @Test
    public void testMinWindow_WindowAtEnd() {
        assertEquals("ABC", solution.minWindow("ZZZABC", "ABC"));
    }

    @Test
    public void testMinWindow_WholeStringIsWindow() {
        assertEquals("ABC", solution.minWindow("ABC", "ABC"));
    }

    @Test
    public void testMinWindow_CaseSensitive() {
        // 'a' != 'A'
        assertEquals("", solution.minWindow("a", "A"));
        assertEquals("A", solution.minWindow("aA", "A"));
    }

    @Test
    public void testMinWindow_NonAlphabetCharacters_IncludingSpacesAndSymbols() {
        assertEquals("$ b", solution.minWindow("a$ b$c", "$ b"));
        assertEquals("!@#", solution.minWindow("xx!@#yy", "!@#"));
    }

    @Test
    public void testMinWindow_RepeatedPattern_LargeOverlap() {
        assertEquals("cab", solution.minWindow("aaabbbcccabc", "abc"));
    }

    @Test
    public void testMinWindow_ClassicExample_AnotherKnownCase() {
        // Commonly cited case: expected "t stri"
        assertEquals("t stri", solution.minWindow("this is a test string", "tist"));
    }

}
