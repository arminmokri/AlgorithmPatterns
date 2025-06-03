"""
Title: Valid Anagram

Given two strings, check if the second string (B) can be constructed
using characters from the first string (A). This requires verifying
that all characters in B appear in A with at least the same frequency.

This problem can be solved efficiently using a frequency count
(hash map or array) for characters in A and B and then comparing counts.

This approach is commonly related to anagrams and substring checks.
"""

debug = True


class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    # Time Complexity O(n), Space Complexity O(1)
    def Solution(self, stringA: str, stringB: str) -> bool:
        frequentList = [0] * 256

        for c in stringA:
            index = ord(c)
            frequentList[index] = frequentList[index] + 1

        for c in stringB:
            index = ord(c)
            frequentList[index] = frequentList[index] - 1

        isAnagram = True
        for item in frequentList:
            if not item == 0:
                isAnagram = False
                break

        return isAnagram


def main():
    stringA = "listen"
    stringB = "silent"
    solution = Solution()
    result = solution.Solution(stringA, stringB)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
