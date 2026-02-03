package stack.valid_parentheses;

import common.PrintHelper;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    public boolean isValid(String s) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        if (PrintHelper.debug) {
            System.out.println("s=" + s);
        }

        Deque<Character> stack = new LinkedList<>();

        List<Character> opening = List.of('(', '{', '[');
        List<Character> closing = List.of(')', '}', ']');

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character peek = stack.peek();
                if (closing.contains(c) && opening.contains(peek)
                        && closing.indexOf(c) == opening.indexOf(peek)
                ) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        boolean isValid = stack.isEmpty();

        if (PrintHelper.debug) {
            System.out.println("stack=" + stack);
            System.out.println("isValid=" + isValid);
        }

        return isValid;
    }

}
