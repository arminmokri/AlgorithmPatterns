package two_pointer.valid_palindrome;

import common.PrintHelper;

public class Solution {

    public boolean isPalindrome(String s) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        int left = 0;
        int right = s.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {

            if (!Character.isAlphabetic(s.charAt(left))) {
                left = left + 1;
            } else if (!Character.isAlphabetic(s.charAt(right))) {
                right = right - 1;
            } else if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left = left + 1;
                right = right - 1;
            } else {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

}
