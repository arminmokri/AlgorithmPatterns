package array.best_time_to_buy_and_sell_stock;


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
        assertEquals(5, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void testEdgeCaseEmptyList() {
        assertEquals(0, solution.maxProfit(new int[]{}));
    }

    @Test
    public void testEdgeCaseSingleElement() {
        assertEquals(0, solution.maxProfit(new int[]{10}));
    }

    @Test
    public void testEdgeCaseTwoElementsProfit() {
        assertEquals(9, solution.maxProfit(new int[]{1, 10}));
    }

    @Test
    public void testEdgeCaseTwoElementsLoss() {
        assertEquals(0, solution.maxProfit(new int[]{10, 1}));
    }

    @Test
    public void testConstantPrices() {
        assertEquals(0, solution.maxProfit(new int[]{5, 5, 5, 5}));
    }

    @Test
    public void testEarlyLowLateHigh() {
        assertEquals(89, solution.maxProfit(new int[]{1, 2, 90, 10, 5}));
    }

    @Test
    public void testLargeJumpAtEnd() {
        assertEquals(98, solution.maxProfit(new int[]{5, 4, 3, 2, 100}));
    }

    @Test
    public void testMultipleOpportunities() {
        assertEquals(4, solution.maxProfit(new int[]{3, 2, 6, 1, 4}));
    }

    @Test
    public void testPriceDipsBeforeRise() {
        assertEquals(1, solution.maxProfit(new int[]{2, 1, 2, 1, 2}));
    }
}