"""

Title: First Missing Positive

Given an unsorted integer array, find the smallest missing positive integer.
Your algorithm should run in O(n) time and use constant extra space.

Approach:
The idea is to rearrange the numbers so that each positive integer i is placed
at index i - 1. Then, scan the array to find the first index i such that A[i] != i + 1.
That index + 1 is the smallest missing positive.

Example:
Input: [3, 4, -1, 1]
Output: 2

"""

debug = True


class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    # Time Complexity O(n), Space Complexity O(n)
    def Solution(self, A: list) -> bool:
        myDict = dict()

        for item in A:
            if item > 0:
                myDict[item] = item

        missing = 1
        while myDict.get(missing) is not None:
            missing = missing + 1

        return missing


def main():
    A = [1, 2, 3, 4, 5, 10]
    # A = [-1, -3]
    solution = Solution()
    result = solution.Solution(A)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
