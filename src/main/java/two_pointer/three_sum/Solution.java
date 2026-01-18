package two_pointer.three_sum;

import common.PrintHelper;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    // def threeSum(self, nums: List[int]) -> List[List[int]]:
    public List<List<Integer>> threeSum(int[] nums) {
        if (PrintHelper.debug) {
            System.out.println();
        }

        Set<List<Integer>> triples = new HashSet<>();

        Map<Integer, Long> frequent = Arrays.stream(nums)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );


        if (PrintHelper.debug) {
            System.out.println("nums=" + PrintHelper.arrayToStringWithoutIndex(nums));
            System.out.println("frequent=" + frequent);
        }


        for (int firstNumberIndex = 0; firstNumberIndex < nums.length; firstNumberIndex++) {
            int firstNumber = nums[firstNumberIndex];
            decreaseItemCounter(frequent, firstNumber);

            int otherTwoNumbersSum = -1 * firstNumber;

            for (int secondNumberIndex = 0; secondNumberIndex < nums.length; secondNumberIndex++) {
                int secondNumber = nums[secondNumberIndex];
                if (frequent.get(secondNumber) <= 0) {
                    continue;
                }
                decreaseItemCounter(frequent, secondNumber);

                int thirdNumber = otherTwoNumbersSum - secondNumber;

                if (frequent.getOrDefault(thirdNumber, -1L) > 0) {
                    List triple = List.of(firstNumber, secondNumber, thirdNumber)
                            .stream()
                            .sorted()
                            .collect(Collectors.toList());
                    triples.add(triple);
                }

                increaseItemCounter(frequent, secondNumber);
            }

            increaseItemCounter(frequent, firstNumber);
        }

        if (PrintHelper.debug) {
            System.out.println("triples=" + triples);
        }


        return triples.stream().collect(Collectors.toList());
    }

    private void increaseItemCounter(Map<Integer, Long> map, Integer item) {
        Long count = map.get(item);
        count = count + 1;
        map.put(item, count);
    }

    private void decreaseItemCounter(Map<Integer, Long> map, Integer item) {
        Long count = map.get(item);
        count = count - 1;
        map.put(item, count);
    }
}
