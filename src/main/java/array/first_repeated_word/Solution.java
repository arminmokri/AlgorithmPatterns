package array.first_repeated_word;

import common.PrintHelper;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String firstRepeatedWord(String text) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        Set<String> repeated = new HashSet<>();
        String firstRepeatedWord = "";
        for (String word : text.split("\\s+")) {
            word = word.toLowerCase();
            if (repeated.contains(word)) {
                firstRepeatedWord = word;
                break;
            } else {
                repeated.add(word);
            }
        }

        return firstRepeatedWord;
    }
}
