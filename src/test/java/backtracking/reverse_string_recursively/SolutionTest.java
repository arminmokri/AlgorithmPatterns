package backtracking.reverse_string_recursively;

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
                "gnimmargorP evoL I",
                solution.reverseString("I Love Programming")
        );
    }

    @Test
    public void testEmptyString() {
        assertEquals("", solution.reverseString(""));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals("A", solution.reverseString("A"));
    }

    @Test
    public void testPalindrome() {
        assertEquals("madam", solution.reverseString("madam"));
    }

    @Test
    public void testNumbersAndSymbols() {
        assertEquals("$#@!4321", solution.reverseString("1234!@#$"));
    }

    @Test
    public void testSpacesOnly() {
        assertEquals("     ", solution.reverseString("     "));
    }

    @Test
    public void testUnicodeCharacters() {
        assertEquals("مالس", solution.reverseString("سلام"));
    }
}
