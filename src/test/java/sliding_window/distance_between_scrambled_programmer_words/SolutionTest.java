package sliding_window.distance_between_scrambled_programmer_words;

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
                10,
                solution.distanceBetweenWords("progrdfammerfgfdmkjfdsprogramfertmer")
        );
        assertEquals(
                3,
                solution.distanceBetweenWords("xyzprogxrammerabcprogrammer123")
        );
        assertEquals(
                0,
                solution.distanceBetweenWords("ppprrrooggrraammmeerr")
        );
        assertEquals(
                0,
                solution.distanceBetweenWords("somethingrandom")
        );
    }

    @Test
    public void testExactlyTwoProgrammersWithSpaces() {
        String s = "programmer" + "-".repeat(15) + "programmer";
        assertEquals(15, solution.distanceBetweenWords(s));
    }

    @Test
    public void testProgrammerAtStartAndEnd() {
        String s = "programmerxxxxxxxmoretextyyyyyyyprogrammer";
        assertEquals("xxxxxxxmoretextyyyyyyy".length(), solution.distanceBetweenWords(s));
    }

    @Test
    public void testOnlyOneProgrammer() {
        assertEquals(0, solution.distanceBetweenWords("p-r-o-g-r-a-m-m-e-r"));
    }

    @Test
    public void testProgrammerLettersOutOfOrderWithNoise() {
        String s = "rpogmarremblahblahblahprogrammer";
        assertEquals("blahblahblah".length(), solution.distanceBetweenWords(s));
    }

    @Test
    public void testMultipleOccurrences() {
        String s = "xxxprogrammerxxxprogrammerxxxprogrammer";
        assertEquals(16, solution.distanceBetweenWords(s));
    }

    @Test
    public void testCaseWithDuplicateLettersButNoValidMatch() {
        String s = "ppppprrrrrooooggggrrrraaaammmmmmmeeeerrrrrr";
        assertEquals(0, solution.distanceBetweenWords(s));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, solution.distanceBetweenWords(""));
    }

    @Test
    public void testShortString() {
        assertEquals(0, solution.distanceBetweenWords("prog"));
    }
}
