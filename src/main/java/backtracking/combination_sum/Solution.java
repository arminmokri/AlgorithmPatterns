package backtracking.combination_sum;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("target=" + target + " candidates" + PrintHelper.arrayToStringWithoutIndex(candidates));
        }

        List<List<Integer>> combinationsSum = new ArrayList<>();

        makeCombinations(candidates, target, combinationsSum, 0, new ArrayList<>(), 0);

        if (PrintHelper.debug) {
            System.out.println("combinationsSum=" + combinationsSum);
        }

        return combinationsSum;
    }


    private void makeCombinations(int[] candidates, int target, List<List<Integer>> combinationsSum, int index, List<Integer> combination, int total) {

        if (target == total) {
            List<Integer> list = List.copyOf(combination);
            if (list.size() > 0) {
                combinationsSum.add(list);
            }
            return;
        } else if (total > target) {
            return;
        } else if (index >= candidates.length) {
            return;
        }

        // choose current candidate (can reuse it)
        combination.add(candidates[index]);
        makeCombinations(candidates, target, combinationsSum, index, combination, total + candidates[index]);

        // backtrack: remove the last added element
        combination.removeLast();

        // skip current candidate, move to next
        makeCombinations(candidates, target, combinationsSum, index + 1, combination, total);
    }
}
