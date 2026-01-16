package array.merge_sorted_array;

import common.PrintHelper;

public class Solution {

    private void addItemToIndexOfArray(int[] array, int index, int value) {
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (PrintHelper.debug) {
            System.out.println();
        }


        if (PrintHelper.debug) {
            System.out.println("m=" + m + " nums1=" + PrintHelper.arrayToStringWithIndex(nums1));
            System.out.println("n=" + n + " nums2=" + PrintHelper.arrayToStringWithIndex(nums2));
        }

        int indexM = 0;
        int indexN = 0;

        for (int i = 0; i < m + n; i++) {

            if (PrintHelper.debug) {
                System.out.println("i=" + i + " indexM=" + indexM + " indexN=" + indexN + " nums1=" + PrintHelper.arrayToStringWithIndex(nums1));
            }

            if (indexN < n && indexM - indexN < m && nums1[indexM] > nums2[indexN]) { // item exist in num2 - item exist in num1 - compare
                addItemToIndexOfArray(nums1, i, nums2[indexN]);
                indexN++;
                indexM++;
                if (PrintHelper.debug) {
                    System.out.println("item exist in num2 - item exist in num1 - compare");
                }
            } else if (indexN < n && indexM - indexN == m) { // item exist in num2 - item not exist in num1
                nums1[i] = nums2[indexN];
                indexN++;
                indexM++;
                if (PrintHelper.debug) {
                    System.out.println("item exist in num2 - item not exist in num1");
                }
            } else { // else
                indexM++;
                if (PrintHelper.debug) {
                    System.out.println("else");
                }
            }
        }

        if (PrintHelper.debug) {
            System.out.println("nums1=" + PrintHelper.arrayToStringWithIndex(nums1));
        }

    }

}
