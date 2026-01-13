package array.first_unique_character_in_a_string;

import common.PrintHelper;

import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public int firstUniqueCharacter(String text) {
        return firstUniqueCharacterA(text);
    }

    private int firstUniqueCharacterA(String text) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("text=" + text);
        }

        int firstUniqueCharacter = -1;

        int[] frequentList = new int[256];
        for(char c : text.toCharArray()){
            frequentList[(int) c]++;
        }

        if (PrintHelper.debug) {
            System.out.println("frequentList=" + frequentList);
        }

        for (int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            if (frequentList[(int) character] == 1) {
                firstUniqueCharacter = i;
                break;
            }
        }

        return firstUniqueCharacter;
    }

    private int firstUniqueCharacterB(String text) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("text=" + text);
        }

        int firstUniqueCharacter = -1;

        Map<String, Long> frequentList = text
                .chars()
                .mapToObj(i -> ((char) i) + "")
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        if (PrintHelper.debug) {
            System.out.println("frequentList=" + frequentList);
        }

        for (int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            Long repeat = frequentList.get(character.toString());
            if (repeat.equals(Long.valueOf(1))) {
                firstUniqueCharacter = i;
                break;
            }
        }

        return firstUniqueCharacter;
    }
}
