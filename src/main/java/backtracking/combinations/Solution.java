package backtracking.combinations;

import common.PrintHelper;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("n=" + n + " k=" + k);
        }

        List<List<Integer>> combines = new ArrayList<>();

        makeCombines(n, k, combines, new ArrayList<>(), 1);

        if (PrintHelper.debug) {
            System.out.println("combines=" + combines);
        }

        return combines;
    }

    public void makeCombines(int n, int k, List<List<Integer>> combines, List<Integer> combine, int index) {

        if (k == combine.size()) {
            List<Integer> list = List.copyOf(combine);
            combines.add(list);
            return;
        }

        for (int i = index; i <= n; i++) {
            combine.add(i);
            makeCombines(n, k, combines, combine, i + 1);
            combine.removeLast();
        }
    }


}
