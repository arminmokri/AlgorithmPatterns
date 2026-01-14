package array.merge_sorted_array;


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
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1}, nums1);

        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    public void testAllZeroInNums1() {
        int[] nums1 = {0, 0, 0};
        int m = 0;
        int[] nums2 = {2, 4, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{2, 4, 6}, nums1);
    }

    @Test
    public void testReverseSorted() {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }

    @Test
    public void testWithDuplicates() {
        int[] nums1 = {1, 1, 1, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 1, 1};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1}, nums1);
    }
}
