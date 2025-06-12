"""
Title: Distance Between Scrambled Programmer Words

You are given a string that may contain one or more disordered occurrences of the word "programmer",
possibly with other characters in between. A valid "programmer" match must contain all the letters
from the word "programmer" (with correct frequency) but can be in any order and with other characters
interspersed.

Your task is to:
1. Find the leftmost substring that contains all letters of "programmer" with correct frequency.
2. Find the rightmost such substring.
3. Return the number of characters strictly between these two matching substrings.

This is a sliding window + frequency count problem.

---

Examples:

Example 1:
Input: "progrdfammerfgfdmkjfdsprogramfertmer"
Output: 21
Explanation:
- First "programmer" match starts at index 0 (inclusive)
- Second "programmer" match ends at index 43 (inclusive)
- Characters between: from index 11 to 32 → length = 21

Example 2:
Input: "xyzprogxrammerabcprogrammer123"
Output: 12
Explanation:
- First "programmer" match from index 3 to 14
- Second "programmer" match from index 18 to 29
- Characters between: from index 15 to 17 → "abc" → length = 3

Example 3:
Input: "ppprrrooggrraammmeerr"
Output: 0
Explanation:
Only one "programmer" match is present → return 0 (nothing in between)

Example 4:
Input: "somethingrandom"
Output: 0
Explanation:
"programmer" never fully appears → return 0

Constraints:
- The input string may contain lowercase letters and symbols.
- Must handle large strings efficiently.
"""

debug = True


class Solution:
    def martixToString(self, myMatrix: list[list] | tuple[tuple]) -> str:
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

    def listToString(self, myList: list | tuple) -> str:
        if myList == []:
            return "[]"

        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def Solution(self, string: str) -> int:
        programmerStr = list("programmer")
        leftPointer = 0
        for i in range(0, len(string)) or not len(programmerStr) == 0:
            c = string[i]
            if c in programmerStr:
                programmerStr.remove(c)
                leftPointer = i

        if debug:
            print("leftPointer=" + str(leftPointer))

        programmerStr = list("programmer")
        rightPointer = 0
        for i in range(len(string) - 1, 0, -1) or not len(programmerStr) == 0:
            c = string[i]
            if c in programmerStr:
                programmerStr.remove(c)
                rightPointer = i

        if debug:
            print("rightPointer=" + str(rightPointer))

        distance = rightPointer - leftPointer - 1
        if distance < 0:
            distance = 0

        return distance


def main():
    # string = "ppprrrooggrraammmeerr"
    string = "xyzprogxrammerabcprogrammer123"
    solution = Solution()
    result = solution.Solution(string)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
