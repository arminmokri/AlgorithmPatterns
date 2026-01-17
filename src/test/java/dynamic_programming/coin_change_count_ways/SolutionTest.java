package dynamic_programming.coin_change_count_ways;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testDefaultCase() {
        assertEquals(5, solution.coinChange(List.of(1, 2, 3), 5));
    }

    @Test
    public void testLargeMatchs() {
        assertEquals(15, solution.coinChange(List.of(1, 2, 5, 10), 12));
    }

    @Test
    public void testZeroAmount() {
        assertEquals(1, solution.coinChange(List.of(1, 2, 5), 0));
    }

    @Test
    public void testNoCoins() {
        assertEquals(0, solution.coinChange(List.of(), 5));
    }

    @Test
    public void testExactSingleCoinMatch() {
        assertEquals(1, solution.coinChange(List.of(5), 5));
    }

    @Test
    public void testCoinsLargerThanTarget() {
        assertEquals(0, solution.coinChange(List.of(4, 5), 3));
    }

    @Test
    public void testSingleCoinMultipleWays() {
        assertEquals(3, solution.coinChange(List.of(1, 2), 4));
    }

    @Test
    public void testLargeTargetSmallCoins() {
        assertEquals(1, solution.coinChange(List.of(1), 10));
    }

    @Test
    public void testHugeCase_naiveRecursionWillTimeOutOrStackOverflow() {
        List<Integer> coins = java.util.stream.IntStream.rangeClosed(1, 50)
                .boxed()
                .toList();
        int target = 100;
        assertEquals(189477547, solution.coinChange(coins, target));
    }
}
