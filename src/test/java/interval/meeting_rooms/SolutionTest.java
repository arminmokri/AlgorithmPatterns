package interval.meeting_rooms;

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
        assertFalse(solution.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        assertTrue(solution.canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
    }

    @Test
    public void testEmptyIntervals() {
        assertTrue(solution.canAttendMeetings(new int[][]{}));
    }

    @Test
    public void testSingleMeeting() {
        assertTrue(solution.canAttendMeetings(new int[][]{{0, 10}}));
    }

    @Test
    public void testNoOverlapSorted() {
        assertTrue(solution.canAttendMeetings(new int[][]{{1, 3}, {4, 6}, {7, 10}}));
    }

    @Test
    public void testNoOverlapUnsorted() {
        assertTrue(solution.canAttendMeetings(new int[][]{{5, 6}, {1, 2}, {3, 4}}));
    }

    @Test
    public void testExactTouchingIntervals() {
        assertTrue(solution.canAttendMeetings(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    @Test
    public void testOverlapAtEnd() {
        assertFalse(solution.canAttendMeetings(new int[][]{{1, 4}, {2, 5}}));
    }

    @Test
    public void testLargeInput() {
        int[][] intervals = new int[5000][2];
        int idx = 0;
        for (int i = 0; i < 10000; i += 2) {
            intervals[idx][0] = i;
            intervals[idx][1] = i + 1;
            idx++;
        }
        assertTrue(solution.canAttendMeetings(intervals));
    }

    @Test
    public void testZeroLengthMeeting() {
        assertTrue(solution.canAttendMeetings(new int[][]{{1, 1}, {2, 3}}));
    }

    @Test
    public void testDuplicateMeetings() {
        assertFalse(solution.canAttendMeetings(new int[][]{{1, 3}, {1, 3}}));
    }
}
