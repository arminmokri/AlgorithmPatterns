package array.length_of_last_word;

import common.PrintHelper;

public class Solution {

    public int lengthOfLastWord(String s) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("s=" + s);
        }

        int index = s.length() - 1;

        // skip spaces
        while (index >= 0 && s.charAt(index) == ' ') {
            index = index - 1;
        }

        int lengthOfLastWord = 0;

        // count last word
        while (index >= 0 && s.charAt(index) != ' ') {
            lengthOfLastWord = lengthOfLastWord + 1;
            index = index - 1;
        }

        return lengthOfLastWord;
    }

}
