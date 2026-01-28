package array.isomorphic_strings;

import common.PrintHelper;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("s=" + s + " t=" + t);
        }

        Map<Character, Character> sToTMapping = new HashMap<>();
        Map<Character, Character> TToSMapping = new HashMap<>();
        boolean isIsomorphic = true;
        if (s.length() != t.length()) {
            isIsomorphic = false;
        }

        for (int i = 0; i < s.length() && isIsomorphic; i++) {
            Character charS = Character.valueOf(s.charAt(i));
            Character charT = Character.valueOf(t.charAt(i));
            if (!sToTMapping.getOrDefault(charS, charT).equals(charT)) {
                isIsomorphic = false;
                break;
            } else if (!TToSMapping.getOrDefault(charT, charS).equals(charS)) {
                isIsomorphic = false;
                break;
            }
            sToTMapping.put(charS, charT);
            TToSMapping.put(charT, charS);
        }

        if (PrintHelper.debug) {
            System.out.println("isIsomorphic=" + isIsomorphic);
        }

        return isIsomorphic;
    }

}
