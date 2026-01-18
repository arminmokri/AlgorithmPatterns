package two_pointer.simple_palindrome_check;

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
        assertTrue(solution.palindromeCheck("racecar"));
    }

    @Test
    public void testSimplePalindromes() {
        assertTrue(solution.palindromeCheck("madam"));
        assertTrue(solution.palindromeCheck("a"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(solution.palindromeCheck(""));
    }

    @Test
    public void testTwoCharacters() {
        assertTrue(solution.palindromeCheck("aa"));
        assertFalse(solution.palindromeCheck("ab"));
    }

    @Test
    public void testEvenLengthPalindromes() {
        assertTrue(solution.palindromeCheck("abba"));
        assertTrue(solution.palindromeCheck("deed"));
    }

    @Test
    public void testNotPalindromes() {
        assertFalse(solution.palindromeCheck("hello"));
        assertFalse(solution.palindromeCheck("palindrome"));
    }

    @Test
    public void testCaseSensitive() {
        assertFalse(solution.palindromeCheck("Racecar"));
    }

    @Test
    public void testWithSpaces() {
        assertFalse(solution.palindromeCheck("nurses run"));
        assertTrue(solution.palindromeCheck("a b b a"));
    }

    @Test
    public void testWithPunctuation() {
        assertFalse(solution.palindromeCheck("madam!"));
    }

    @Test
    public void testLongPalindrome() {
        assertTrue(solution.palindromeCheck("abcdedcba"));
        assertFalse(solution.palindromeCheck("abcdedcbz"));
    }
}
