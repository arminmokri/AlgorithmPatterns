package array.isomorphic_strings;

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
        assertTrue(solution.isIsomorphic("egg", "add"));
        assertFalse(solution.isIsomorphic("foo", "bar"));
        assertTrue(solution.isIsomorphic("paper", "title"));
    }

    @Test
    public void testSingleCharacterStrings() {
        assertTrue(solution.isIsomorphic("a", "b"));
        assertTrue(solution.isIsomorphic("x", "x"));
    }

    @Test
    public void testDifferentLengths() {
        assertFalse(solution.isIsomorphic("ab", "a"));
        assertFalse(solution.isIsomorphic("a", "ab"));
    }

    @Test
    public void testRepeatedPatternValid() {
        assertTrue(solution.isIsomorphic("abab", "cdcd"));
        assertTrue(solution.isIsomorphic("aaaa", "bbbb"));
    }

    @Test
    public void testRepeatedPatternInvalid() {
        assertFalse(solution.isIsomorphic("abab", "cccc"));
        assertFalse(solution.isIsomorphic("abba", "abab"));
    }

    @Test
    public void testSameCharactersDifferentMapping() {
        assertFalse(solution.isIsomorphic("aa", "ab"));
        assertFalse(solution.isIsomorphic("bb", "ba"));
    }

    @Test
    public void testEmptyStrings() {
        assertTrue(solution.isIsomorphic("", ""));
    }

    @Test
    public void testWithSpecialCharacters() {
        assertTrue(solution.isIsomorphic("!@!", "#$#"));
        assertFalse(solution.isIsomorphic("!@!", "###"));
    }

    @Test
    public void testLongerStrings() {
        assertTrue(solution.isIsomorphic("abcdefghijklmnopqrstuvwxyz",
                "zyxwvutsrqponmlkjihgfedcba"));
    }

    @Test
    public void testCaseSensitivity() {
        assertFalse(solution.isIsomorphic("aA", "bb"));
        assertTrue(solution.isIsomorphic("aA", "bC"));
    }

}
