package array.first_repeated_word;

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
                "alpha",
                solution.firstRepeatedWord("alpha beta gamma alpha delta beta")
        );
    }

    @Test
    public void testNoRepeats() {
        assertEquals("", solution.firstRepeatedWord("apple banana cherry"));
    }

    @Test
    public void testRepeatsImmediately() {
        assertEquals("one", solution.firstRepeatedWord("one one two three"));
    }

    @Test
    public void testCaseSensitive() {
        assertEquals("dog", solution.firstRepeatedWord("Dog dog DOG"));
    }

    @Test
    public void testTrailingAndLeadingSpaces() {
        assertEquals(
                "this",
                solution.firstRepeatedWord("  this  is   a test this is")
        );
    }

    @Test
    public void testOnlyOneWord() {
        assertEquals("", solution.firstRepeatedWord("hello"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", solution.firstRepeatedWord(""));
    }

    @Test
    public void testAllRepeated() {
        assertEquals("x", solution.firstRepeatedWord("x x x x x"));
    }
}
