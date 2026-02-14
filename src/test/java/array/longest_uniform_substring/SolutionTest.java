package array.longest_uniform_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    void testDefaultCase() {
        Solution solution = new Solution();

        // "abbbcccc" → longest = "cccc" (start=4, len=4)
        assertArrayEquals(
                new int[]{4, 4},
                solution.repeatedSubstring("abbbcccc")
        );

        // "cabcccc" → longest = "cccc" (start=3, len=4)
        assertArrayEquals(
                new int[]{3, 4},
                solution.repeatedSubstring("cabcccc")
        );

        // "100000111" → longest = "00000" (start=1, len=5)
        assertArrayEquals(
                new int[]{1, 5},
                solution.repeatedSubstring("100000111")
        );

        // "aabbCC" → first longest = "aa" (start=0, len=2)
        // (ties keep the first occurrence in your implementation)
        assertArrayEquals(
                new int[]{0, 2},
                solution.repeatedSubstring("aabbCC")
        );

        // "" → empty string → loop never runs
        // indexStartMax=0, maxLen=Integer.MIN_VALUE
        assertArrayEquals(
                new int[]{-1, Integer.MIN_VALUE},
                solution.repeatedSubstring("")
        );

        // "aaabca" → longest = "aaa" (start=0, len=3)
        assertArrayEquals(
                new int[]{0, 3},
                solution.repeatedSubstring("aaabca")
        );

        // "aab" → longest = "aa" (start=0, len=2)
        assertArrayEquals(
                new int[]{0, 2},
                solution.repeatedSubstring("aab")
        );
    }

    @Test
    void testSingleCharacter() {
        // "a" → no repetition → based on your implementation behavior
        assertArrayEquals(
                new int[]{0, 1},
                solution.repeatedSubstring("a")
        );
    }

    @Test
    void testAllSameCharacter() {
        // "aaaaaa" → longest = "aaaaaa" (start=0, len=6)
        assertArrayEquals(
                new int[]{0, 6},
                solution.repeatedSubstring("aaaaaa")
        );
    }

    @Test
    void testNoRepetition() {
        // "abcdef" → no repeated adjacent characters
        assertArrayEquals(
                new int[]{0, 1},
                solution.repeatedSubstring("abcdef")
        );
    }

    @Test
    void testLongestAtBeginning() {
        // "xxxxabc" → longest = "xxxx" (start=0, len=4)
        assertArrayEquals(
                new int[]{0, 4},
                solution.repeatedSubstring("xxxxabc")
        );
    }

    @Test
    void testLongestAtEnd() {
        // "abyyyy" → longest = "yyyy" (start=2, len=4)
        assertArrayEquals(
                new int[]{2, 4},
                solution.repeatedSubstring("abyyyy")
        );
    }

    @Test
    void testMultipleEqualLengthSequences() {
        // "aaabbbccc" → longest length = 3
        // your implementation keeps first occurrence → "aaa"
        assertArrayEquals(
                new int[]{0, 3},
                solution.repeatedSubstring("aaabbbccc")
        );
    }

    @Test
    void testCaseSensitivity() {
        // "aaAAaa" → longest = "aa" at index 0 (case-sensitive comparison)
        assertArrayEquals(
                new int[]{0, 2},
                solution.repeatedSubstring("aaAAaa")
        );
    }

    @Test
    void testSpecialCharacters() {
        // "!!@@@####" → longest = "####" (start=5, len=4)
        assertArrayEquals(
                new int[]{5, 4},
                solution.repeatedSubstring("!!@@@####")
        );
    }

    @Test
    void testNumbersAndLettersMixed() {
        // "11aa2222bb" → longest = "2222" (start=4, len=4)
        assertArrayEquals(
                new int[]{4, 4},
                solution.repeatedSubstring("11aa2222bb")
        );
    }

    @Test
    void testLongUniformMiddle() {
        // "abcdddddef" → longest = "ddddd" (start=3, len=5)
        assertArrayEquals(
                new int[]{3, 5},
                solution.repeatedSubstring("abcdddddef")
        );
    }

}
