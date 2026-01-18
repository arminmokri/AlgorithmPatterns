package two_pointer.simple_palindrome_check;

import common.PrintHelper;

public class Solution {

    public boolean palindromeCheck(String str) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        int left = 0;
        int right = str.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        return isPalindrome;
    }
}
