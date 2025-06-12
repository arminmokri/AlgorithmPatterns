"""
Title: Reverse a String Recursively

Description:
Implement a recursive function that takes a string as input and returns
the reversed string as output.

Example:
Input:  "hello"
Output: "olleh"

Constraints:
- Do not use built-in reverse functions (e.g., [::-1], reversed()).
- Must be solved using recursion.
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

    # Time Complexity O(n^2), Space Complexity O(n)
    def Solution(self, string: list) -> list:
        if len(string) == 0:
            return ""
        else:
            return string[-1:] + self.Solution(string[:-1])

    # todo it has solution with Time Complexity O(n), Space Complexity O(n)

def main():
    string = "I Love Programming"
    solution = Solution()
    result = solution.Solution(string)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
