package dynamic_programming.edit_distance;

import common.PrintHelper;

import java.util.List;
import java.util.Objects;

public class Solution {

    public int minDistance(String word1, String word2) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("word1=" + word1 + " word2=" + word2);
        }


        //return recursion(word1, word2, 0, 0);
        //return memoization(word1, word2, 0, 0, new Integer[word1.length()][word2.length()]);
        return bottomUp(word1, word2);
    }

    private int recursion(String word1, String word2, int indexWord1, int indexWord2) {
        if (indexWord1 == word1.length()) {
            return word2.length() - indexWord2; // insert remaining
        } else if (indexWord2 == word2.length()) {
            return word1.length() - indexWord1; // delete remaining
        }


        if (word1.charAt(indexWord1) == word2.charAt(indexWord2)) {
            return recursion(word1, word2, indexWord1 + 1, indexWord2 + 1);
        } else {
            int insert = recursion(word1, word2, indexWord1, indexWord2 + 1) + 1;
            int delete = recursion(word1, word2, indexWord1 + 1, indexWord2) + 1;
            int replace = recursion(word1, word2, indexWord1 + 1, indexWord2 + 1) + 1;
            return List.of(insert, delete, replace).stream().min(Integer::compare).orElse(0);
        }
    }

    private int memoization(String word1, String word2, int indexWord1, int indexWord2, Integer[][] memo) {
        if (indexWord1 == word1.length()) {
            return word2.length() - indexWord2; // insert remaining
        } else if (indexWord2 == word2.length()) {
            return word1.length() - indexWord1; // delete remaining
        } else if (Objects.nonNull(memo[indexWord1][indexWord2])) {
            return memo[indexWord1][indexWord2];
        }

        if (word1.charAt(indexWord1) == word2.charAt(indexWord2)) {
            memo[indexWord1][indexWord2] = memoization(word1, word2, indexWord1 + 1, indexWord2 + 1, memo);
        } else {
            int insert = memoization(word1, word2, indexWord1, indexWord2 + 1, memo) + 1;
            int delete = memoization(word1, word2, indexWord1 + 1, indexWord2, memo) + 1;
            int replace = memoization(word1, word2, indexWord1 + 1, indexWord2 + 1, memo) + 1;
            int min = List.of(insert, delete, replace).stream().min(Integer::compare).orElse(0);
            memo[indexWord1][indexWord2] = min;
        }
        return memo[indexWord1][indexWord2];
    }

    private int bottomUp(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = min operations to convert word1[0..i-1] → word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i; // delete all
        for (int j = 0; j <= n; j++) dp[0][j] = j; // insert all

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // match
                } else {
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }

}
