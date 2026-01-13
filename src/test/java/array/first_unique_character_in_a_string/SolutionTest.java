package array.first_unique_character_in_a_string;

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
        assertEquals(1, solution.firstUniqueCharacter("stress"));
    }

    @Test
    public void testNoUniqueCharacter() {
        assertEquals(-1, solution.firstUniqueCharacter("aabbcc"));
    }

    @Test
    public void testFirstCharacterUnique() {
        assertEquals(0, solution.firstUniqueCharacter("abcdef"));
    }

    @Test
    public void testLastCharacterUnique() {
        assertEquals(6, solution.firstUniqueCharacter("aabbccd"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(-1, solution.firstUniqueCharacter(""));
    }

    @Test
    public void testAllUniqueCharacters() {
        assertEquals(0, solution.firstUniqueCharacter("abcde"));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(0, solution.firstUniqueCharacter("z"));
    }

    @Test
    public void testMixedCase() {
        assertEquals(0, solution.firstUniqueCharacter("AaBbCcD"));
    }
}
