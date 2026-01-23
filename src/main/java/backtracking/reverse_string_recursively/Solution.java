package backtracking.reverse_string_recursively;

import common.PrintHelper;

public class Solution {

    public String reverseString(String str) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("str=" + str);
        }


        return makeReverse(str);
    }

    private String makeReverse(String string) {
        int len = string.length();
        if (len == 0) {
            return "";
        }
        return string.charAt(len - 1) + makeReverse(string.substring(0, len - 1));
    }

}
