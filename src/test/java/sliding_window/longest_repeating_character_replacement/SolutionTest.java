package sliding_window.longest_repeating_character_replacement;

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
        assertEquals(4, solution.characterReplacement("ABAB", 2));
        assertEquals(4, solution.characterReplacement("AABABBA", 1));
    }

    @Test
    public void testSingleCharacterString() {
        assertEquals(1, solution.characterReplacement("A", 0));
        assertEquals(1, solution.characterReplacement("A", 5));
    }

    @Test
    public void testAllSameCharacters() {
        assertEquals(5, solution.characterReplacement("AAAAA", 0));
        assertEquals(5, solution.characterReplacement("AAAAA", 2));
    }

    @Test
    public void testNoReplacementsAllowed() {
        assertEquals(1, solution.characterReplacement("ABCDE", 0));
    }

    @Test
    public void testAllCharactersDifferentWithReplacements() {
        assertEquals(3, solution.characterReplacement("ABCDE", 2));
        assertEquals(5, solution.characterReplacement("ABCDE", 4));
    }

    @Test
    public void testLargeKExceedsStringLength() {
        assertEquals(4, solution.characterReplacement("ABCD", 10));
    }

    @Test
    public void testAlternatingCharacters() {
        assertEquals(3, solution.characterReplacement("ABABAB", 1));
        assertEquals(5, solution.characterReplacement("ABABAB", 2));
    }

    @Test
    public void testWindowExpansionAndShrink() {
        assertEquals(5, solution.characterReplacement("AAABBC", 2));
    }

    @Test
    public void testEdgeCaseEmptyString() {
        assertEquals(0, solution.characterReplacement("", 0));
    }

    @Test
    public void testLowercaseCharacters() {
        assertEquals(4, solution.characterReplacement("aabb", 2));
    }

    @Test
    public void testMixedFrequencyDominantCharChanges() {
        assertEquals(9, solution.characterReplacement("AABAACAAA", 2));
    }

    @Test
    public void testVeryLargeStringPerformance() {
        // Build a large string of 1000 characters
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i % 2 == 0 ? 'A' : 'B');
        }
        String largeInput = sb.toString();

        assertEquals(3, solution.characterReplacement(largeInput, 1));
    }

}
