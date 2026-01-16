package array.two_stacks_in_an_array;

import common.PrintHelper;

import java.util.Arrays;

public class Solution {

    private final int size;
    private int pointerA;
    private int pointerB;
    private final Integer[] myList;

    public Solution(int size) {
        this.size = size;
        this.pointerA = -1;
        this.pointerB = size;
        this.myList = new Integer[size];
    }

    public boolean pushA(Integer val) {
        if (pointerA + 1 < pointerB) {
            pointerA = pointerA + 1;
            myList[pointerA] = val;
            return true;
        } else {
            return false;
        }
    }

    public Integer popA() {
        Integer val = null;
        if (pointerA >= 0) {
            val = myList[pointerA];
            myList[pointerA] = null;
            pointerA = pointerA - 1;
        }
        return val;
    }

    public boolean pushB(Integer val) {
        if (pointerA + 1 < pointerB) {
            pointerB = pointerB - 1;
            myList[pointerB] = val;
            return true;
        } else {
            return false;
        }
    }

    public Integer popB() {
        Integer val = null;
        if (pointerB < size) {
            val = myList[pointerB];
            myList[pointerB] = null;
            pointerB = pointerB + 1;
        }
        return val;
    }

    public Integer[] getMyList() {
        return Arrays.copyOf(myList, size);
    }

    @Override
    public String toString() {
        return "pointerA="
                + pointerA
                + " pointerB="
                + pointerB
                + " myList="
                + PrintHelper.arrayToStringWithIndex(myList);
    }

    public void printSpace() {
        System.out.println(this);
    }
}
