package two_pointer.move_zeroes;

import common.PrintHelper;

public class Solution {

    public void moveZeroes(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }
        moveZeroesB(nums);
    }

    // Improved Algorithm
    private void moveZeroesB(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithoutIndex(nums));
        }

        int slow = 0; // next position to place a non-zero

        for (int fast = 0; fast < nums.length; fast++) {

            String s = "slow=" + slow +
                    " fast=" + fast + " " +
                    "nums=" + PrintHelper.arrayToStringWithoutIndex(nums);

            if (nums[fast] != 0) {
                if (slow < fast) {
                    s = s + " - SWAP";
                    swap(nums, slow, fast);
                }
                s = s + " - INC slow";
                slow++;
            }

            if (PrintHelper.debug) {
                System.out.println(s);
            }
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithoutIndex(nums));
        }
    }


    // First Algorithm that I did
    private void moveZeroesA(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        int zeroPointer = 0;
        int noneZeroPointer = 0;

        while (zeroPointer < nums.length && noneZeroPointer < nums.length) {

            String s = "zeroPointer=" + zeroPointer +
                    " noneZeroPointer=" + noneZeroPointer + " " +
                    "nums=" + PrintHelper.arrayToStringWithoutIndex(nums);

            if (nums[zeroPointer] != 0) {
                zeroPointer = zeroPointer + 1;
                s = s + " IF - INC zeroPointer";
            } else if (nums[noneZeroPointer] == 0) {
                noneZeroPointer = noneZeroPointer + 1;
                s = s + " IF - INC noneZeroPointer";
            } else if (zeroPointer < noneZeroPointer) {
                swap(nums, zeroPointer, noneZeroPointer);
                zeroPointer = zeroPointer + 1;
                s = s + " if - SWAP";
            } else {
                noneZeroPointer = noneZeroPointer + 1;
                s = s + " ELSE - INC noneZeroPointer";
            }

            if (PrintHelper.debug) {
                System.out.println(s);
            }
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithoutIndex(nums));
        }

    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
