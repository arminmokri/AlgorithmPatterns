package two_pointer.valid_palindrome;

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
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(solution.isPalindrome("race a car"));
        assertTrue(solution.isPalindrome(" "));
    }

    @Test
    public void testEmptyString() {
        assertTrue(solution.isPalindrome(""));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(solution.isPalindrome("a"));
    }

    @Test
    public void testOnlyNonAlphabetic() {
        assertTrue(solution.isPalindrome("!!!???")); // Only ignored characters
    }

    @Test
    public void testCaseInsensitivity() {
        assertTrue(solution.isPalindrome("Aa"));
    }

    @Test
    public void testMixedCharacters() {
        assertTrue(solution.isPalindrome("No 'x' in Nixon"));
    }

    @Test
    public void testWithNumbersAndLetters() {
        assertTrue(solution.isPalindrome("1a2!a1"));
    }

    @Test
    public void testNotPalindrome() {
        assertFalse(solution.isPalindrome("Hello, world!"));
    }

    @Test
    public void testLongPalindrome() {
        String s = "Able was I ere I saw Elba";
        assertTrue(solution.isPalindrome(s));
    }
}
