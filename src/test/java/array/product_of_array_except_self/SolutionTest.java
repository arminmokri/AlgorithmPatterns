package array.product_of_array_except_self;


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
    public void testDefaultCase() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, solution.productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

    @Test
    public void testProductExceptSelf_DefaultCase() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, solution.productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

    @Test
    public void testProductExceptSelf_SingleElement() {
        // Common convention for this problem: product of "all other elements" for a single item is 1.
        assertArrayEquals(new int[]{1}, solution.productExceptSelf(new int[]{7}));
    }

    @Test
    public void testProductExceptSelf_TwoElements() {
        assertArrayEquals(new int[]{5, 2}, solution.productExceptSelf(new int[]{2, 5}));
    }

    @Test
    public void testProductExceptSelf_AllOnes() {
        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, solution.productExceptSelf(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void testProductExceptSelf_AllNegativeNoZero() {
        // [-1, -2, -3, -4] -> total product = 24
        // result: [24/-1=-24, 24/-2=-12, 24/-3=-8, 24/-4=-6]
        assertArrayEquals(new int[]{-24, -12, -8, -6}, solution.productExceptSelf(new int[]{-1, -2, -3, -4}));
    }

    @Test
    public void testProductExceptSelf_ContainsOneZero() {
        // Only the index with zero gets the product of all non-zero values; others become 0.
        assertArrayEquals(new int[]{0, 0, 8, 0}, solution.productExceptSelf(new int[]{2, 1, 0, 4}));
    }

    @Test
    public void testProductExceptSelf_ContainsTwoZeros() {
        // With 2+ zeros, every position's product except self includes at least one zero => all zeros.
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, solution.productExceptSelf(new int[]{0, 2, 0, 4, 5}));
    }

    @Test
    public void testProductExceptSelf_MixedSignsNoZero() {
        // total product: (-1)*2*(-3)*4 = 24
        assertArrayEquals(new int[]{-24, 12, -8, 6}, solution.productExceptSelf(new int[]{-1, 2, -3, 4}));
    }

    @Test
    public void testProductExceptSelf_RepeatedValues() {
        assertArrayEquals(new int[]{27, 27, 27, 27}, solution.productExceptSelf(new int[]{3, 3, 3, 3}));
    }

    @Test
    public void testProductExceptSelf_ZeroAtBeginning() {
        assertArrayEquals(new int[]{24, 0, 0, 0}, solution.productExceptSelf(new int[]{0, 1, 2, 12}));
    }

}
