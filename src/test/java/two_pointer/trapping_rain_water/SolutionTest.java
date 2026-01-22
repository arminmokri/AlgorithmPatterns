package two_pointer.trapping_rain_water;

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
        assertEquals(6, solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, solution.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    @Test
    public void testEmptyArrayReturnsZero() {
        assertEquals(0, solution.trap(new int[]{}));
    }

    @Test
    public void testSingleBarReturnsZero() {
        assertEquals(0, solution.trap(new int[]{5}));
    }

    @Test
    public void testTwoBarsReturnsZero() {
        assertEquals(0, solution.trap(new int[]{5, 1}));
    }

    @Test
    public void testAllZerosReturnsZero() {
        assertEquals(0, solution.trap(new int[]{0, 0, 0, 0}));
    }

    @Test
    public void testStrictlyIncreasingReturnsZero() {
        assertEquals(0, solution.trap(new int[]{0, 1, 2, 3, 4, 5}));
    }

    @Test
    public void testStrictlyDecreasingReturnsZero() {
        assertEquals(0, solution.trap(new int[]{5, 4, 3, 2, 1, 0}));
    }

    @Test
    public void testFlatPlateauReturnsZero() {
        assertEquals(0, solution.trap(new int[]{3, 3, 3, 3}));
    }

    @Test
    public void testSimpleBowl() {
        // 2 _ 2 traps 2 units
        assertEquals(2, solution.trap(new int[]{2, 0, 2}));
    }

    @Test
    public void testBowlWithPlateauBottom() {
        // 3 0 0 3 traps (3-0)+(3-0)=6
        assertEquals(6, solution.trap(new int[]{3, 0, 0, 3}));
    }

    @Test
    public void testMultipleBasins() {
        // Basins: [2,0,2] =>2 and [2,0,2] =>2 total 4
        assertEquals(4, solution.trap(new int[]{2, 0, 2, 0, 2}));
    }

    @Test
    public void testAlternatingPeaksAndValleys() {
        // 3 0 3 0 3 traps 3 + 3 = 6
        assertEquals(6, solution.trap(new int[]{3, 0, 3, 0, 3}));
    }

    @Test
    public void testWideValley() {
        // 5 2 1 2 1 5 traps: (3+4+3+4)=14? wait compute vs 5 walls:
        // min(5,5)-2=3, -1=4, -2=3, -1=4 => 14
        assertEquals(14, solution.trap(new int[]{5, 2, 1, 2, 1, 5}));
    }

    @Test
    public void testValleyWithDifferentWallHeights() {
        // left wall 4 right wall 3 => water level 3 over middle
        // 4 1 0 2 3 => (3-1)+(3-0)+(3-2)=2+3+1=6
        assertEquals(6, solution.trap(new int[]{4, 1, 0, 2, 3}));
    }

    @Test
    public void testLeetCodeClassicSmall() {
        // 0 2 0 2 traps 2
        assertEquals(2, solution.trap(new int[]{0, 2, 0, 2}));
    }

    @Test
    public void testZerosAtEndsDoNotAffect() {
        // 0 3 0 1 0 2 0 => between 3 and 2: levels vary, total 5
        // indices: [0,3,0,1,0,2,0]
        // water: at 2 =>2, at 3=>1, at 4=>2 => total 5
        assertEquals(5, solution.trap(new int[]{0, 3, 0, 1, 0, 2, 0}));
    }

    @Test
    public void testLargeEqualWallsWithInteriorHills() {
        // 4 1 3 1 4:
        // water level 4: (3 + 1 + 3) = 7
        assertEquals(7, solution.trap(new int[]{4, 1, 3, 1, 4}));
    }

}
