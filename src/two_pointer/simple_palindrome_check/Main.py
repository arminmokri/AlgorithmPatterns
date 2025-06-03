"""
Title: Simple Palindrome Check

Check if the input string is symmetrical (a palindrome), meaning it reads the same forwards and backwards exactly,
without ignoring spaces, cases, or punctuation.

The two-pointer approach compares characters from the start and end moving toward the center.
"""

debug = True


class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    # Time Complexity O(n), Space Complexity O(1)
    def Solution(self, string: str) -> bool:
        isPalindrome = True

        for i in range(0, int(len(string) / 2)):
            leftChar = string[i]
            rightChar = string[len(string) - (i + 1)]
            if not leftChar == rightChar:
                isPalindrome = False
                break

        return isPalindrome


def main():
    string = "racecar"
    solution = Solution()
    result = solution.Solution(string)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
