package array.longest_palindrome;

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
        assertEquals(7, solution.longestPalindrome("abccccdd"));
        assertEquals(1, solution.longestPalindrome("a"));
    }

    @Test
    public void testLongestPalindrome_AllEvenCounts() {
        assertEquals(6, solution.longestPalindrome("aabbcc")); // all pairs -> 6
    }

    @Test
    public void testLongestPalindrome_MixedWithOneCenterOdd() {
        assertEquals(9, solution.longestPalindrome("aaabbbbcc")); // pairs=8 + center=1 -> 9
    }

    @Test
    public void testLongestPalindrome_AllOddsManyChars() {
        assertEquals(1, solution.longestPalindrome("abcde")); // no pairs, pick 1 center
    }

    @Test
    public void testLongestPalindrome_OnlyOnePairNoCenter() {
        assertEquals(2, solution.longestPalindrome("aa")); // one pair
    }

    @Test
    public void testLongestPalindrome_RepeatedSingleCharOddLength() {
        assertEquals(5, solution.longestPalindrome("aaaaa")); // 4 from pairs + 1 center
    }

    @Test
    public void testLongestPalindrome_CaseSensitiveCountsSeparately() {
        assertEquals(1, solution.longestPalindrome("Aa")); // 'A' != 'a', no pair
    }

    @Test
    public void testLongestPalindrome_MultiplePairsAndCenterAvailable() {
        assertEquals(11, solution.longestPalindrome("aaBBccddeee"));
        // pairs: aa(2) + BB(2) + cc(2) + dd(2) + ee(2) = 10, center from leftover 'e' = 1 => 11
    }

    @Test
    public void testLongestPalindrome_IncludesDigitsAndSymbols() {
        assertEquals(7, solution.longestPalindrome("1122!!3"));
        // pairs: 11(2)+22(2)+!!(2)=6, center from '3'=1 => 7
    }

    @Test
    public void testLongestPalindrome_EmptyString() {
        assertEquals(0, solution.longestPalindrome("")); // nothing to use
    }
}
