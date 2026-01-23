package backtracking.permutations;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithoutIndex(nums));
        }

        List<List<Integer>> permutes = new ArrayList<>();

        makePermutes(nums, permutes, new ArrayList<>(), new boolean[nums.length]);

        if (PrintHelper.debug) {
            System.out.println("permutes=" + permutes);
        }

        return permutes;
    }

    private void makePermutes(int[] nums, List<List<Integer>> permutes, List<Integer> permute, boolean[] visited) {
        if (permute.size() == nums.length) {
            List<Integer> list = List.copyOf(permute);
            permutes.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            permute.add(nums[i]);

            makePermutes(nums, permutes, permute, visited);

            permute.removeLast();
            visited[i] = false;
        }
    }
}
