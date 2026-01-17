package dynamic_programming.coin_change;

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
        assertEquals(3, solution.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, solution.coinChange(new int[]{2}, 3));
        assertEquals(0, solution.coinChange(new int[]{1}, 0));
    }

    @Test
    public void testSingleCoinExactMatch() {
        assertEquals(1, solution.coinChange(new int[]{5}, 5));
    }

    @Test
    public void testSingleCoinNoMatch() {
        assertEquals(-1, solution.coinChange(new int[]{3}, 2));
    }

    @Test
    public void testMultipleCoins() {
        assertEquals(3, solution.coinChange(new int[]{2, 3, 6}, 7));     // 3 + 2 + 2 = 7
        assertEquals(1, solution.coinChange(new int[]{2, 3, 6, 7}, 7));  // 7
    }

    @Test
    public void testLargeAmount() {
        assertEquals(20, solution.coinChange(new int[]{1, 2, 5}, 100));  // 20 coins of 5
    }

    @Test
    public void testLargeCoinSmallAmount() {
        assertEquals(-1, solution.coinChange(new int[]{100}, 1));
    }

    @Test
    public void testEmptyCoinList() {
        assertEquals(-1, solution.coinChange(new int[]{}, 7));
    }

    @Test
    public void testZeroAmount() {
        assertEquals(0, solution.coinChange(new int[]{1, 2, 5}, 0));
    }

    @Test
    public void testDuplicateCoins() {
        assertEquals(3, solution.coinChange(new int[]{1, 1, 2, 2, 5}, 11));
    }

    @Test
    public void testUnreachableAmount() {
        assertEquals(-1, solution.coinChange(new int[]{2, 4}, 7));
    }
}
