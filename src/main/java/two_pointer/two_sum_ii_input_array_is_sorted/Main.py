from typing import List, Tuple
import unittest
from bisect import bisect_left

debug = True


class Solution:
    def matrixToString(self, myMatrix: List[List] | Tuple[Tuple]) -> str:
        if myMatrix == []:
            return "[]"
        elif myMatrix == [[]]:
            return "[[]]"

        str_matrix = [[str(val) for val in row] for row in myMatrix]
        max_width = max(len(val) for row in str_matrix for val in row)

        return "\n".join(
            "[ " + ", ".join(f"{val:>{max_width}}" for val in row) + " ]"
            for row in str_matrix
        )

    def listToString(self, myList: List | Tuple) -> str:
        if myList == []:
            return "[]"

        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    # Time Complexity O(n^2), Space Complexity O(1)
    def twoSumA(self, numbers: List, target: int) -> List:
        if debug:
            print()

        indexA = -1
        indexB = -1

        for i in range(len(numbers)):
            a = numbers[i]
            for j in range(i + 1, len(numbers)):
                b = numbers[j]
                if a + b == target:
                    indexA = i + 1
                    indexB = j + 1
                elif a + b > target:
                    break
            if not indexA == -1:
                break

        return [indexA, indexB]

    # Time Complexity O(nlogn), Space Complexity O(1)
    def twoSumB(self, numbers: List, target: int) -> List:
        if debug:
            print()

        def BinarySearch(self, a, x):
            i = bisect_left(a, x)
            if i != len(a) and a[i] == x:
                return i
            else:
                return -1

        indexA = -1
        indexB = -1

        for i in range(len(numbers)):
            a = numbers[i]
            b = target - a
            j = BinarySearch(numbers, b)
            print(j)
            if not i == j and j >= 0:
                indexA = i + 1
                indexB = j + 1
                break

        return [indexA, indexB]

    # Time Complexity O(n), Space Complexity O(n)
    def twoSumC(self, numbers: List, target: int) -> List:
        if debug:
            print()

        indexA = -1
        indexB = -1

        myMap = dict()
        for i, n in enumerate(numbers):
            myMap[n] = i

        for i in range(len(numbers)):
            a = numbers[i]
            b = target - a
            j = myMap.get(b)
            if j is not None:
                indexA = i + 1
                indexB = j + 1
                break

        return [indexA, indexB]

    # Time Complexity O(n), Space Complexity O(1)
    def twoSumD(self, numbers: List, target: int) -> List:
        if debug:
            print()

        indexA = -1
        indexB = -1

        left = 0
        right = len(numbers) - 1

        while left < right:
            sum = numbers[left] + numbers[right]

            if sum == target:
                indexA = left + 1
                indexB = right + 1
                break
            elif sum > target:
                right = right - 1
            elif sum < target:
                left = left + 1

        return [indexA, indexB]

    def twoSum(self, numbers: List, target: int) -> List:
        return self.twoSumD(numbers, target)


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.twoSum([2, 7, 11, 15], 9), [1, 2])
        self.assertEqual(self.solution.twoSum([2, 3, 4], 6), [1, 3])
        self.assertEqual(self.solution.twoSum([-1, 0], -1), [1, 2])


def main():
    unittest.main()


if __name__ == "__main__":
    main()
