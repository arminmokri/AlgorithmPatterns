package array.length_of_last_word;

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
        assertEquals(5, solution.lengthOfLastWord("Hello World"));
        assertEquals(4, solution.lengthOfLastWord("   fly me   to   the moon  "));
        assertEquals(6, solution.lengthOfLastWord("luffy is still joyboy"));
    }

    @Test
    public void testSingleWordNoSpaces() {
        assertEquals(5, solution.lengthOfLastWord("Hello"));
    }

    @Test
    public void testTrailingSpacesOnly() {
        assertEquals(5, solution.lengthOfLastWord("Hello     "));
    }

    @Test
    public void testLeadingSpacesOnly() {
        assertEquals(5, solution.lengthOfLastWord("     Hello"));
    }

    @Test
    public void testMultipleSpacesBetweenWords() {
        assertEquals(5, solution.lengthOfLastWord("Hi    there"));
    }

    @Test
    public void testOnlySpaces() {
        assertEquals(0, solution.lengthOfLastWord("     "));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, solution.lengthOfLastWord(""));
    }

    @Test
    public void testSingleCharacterWord() {
        assertEquals(1, solution.lengthOfLastWord("a"));
    }

    @Test
    public void testSingleCharacterWithSpaces() {
        assertEquals(1, solution.lengthOfLastWord("   a   "));
    }

    @Test
    public void testNumbersAsWord() {
        assertEquals(3, solution.lengthOfLastWord("test 123"));
    }

    @Test
    public void testSpecialCharacters() {
        assertEquals(4, solution.lengthOfLastWord("hello @#$%"));
    }

    @Test
    public void testVeryLongLastWord() {
        assertEquals(9, solution.lengthOfLastWord("short superlong"));
    }
}
