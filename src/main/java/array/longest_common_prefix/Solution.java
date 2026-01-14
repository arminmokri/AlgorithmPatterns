package array.longest_common_prefix;

import common.PrintHelper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println(List.of(strs));
        }

        String shortestString = Stream.of(strs).min(Comparator.comparing(String::length)).orElse("");
        String longestPrefix = "";

        for (int i = shortestString.length(); i > 0; i--) {
            String prefixString = shortestString.substring(0, i);

            if (PrintHelper.debug) {
                System.out.println("prefixString=" + prefixString);
            }

            int flag = 0;
            for (int j = 0; j < strs.length; j++) {
                String currentString = strs[j];
                if (currentString.equals(shortestString)) {
                    continue;
                }
                if (!currentString.startsWith(prefixString)) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                longestPrefix = prefixString;
                break;
            }
        }


        return longestPrefix;
    }

}
