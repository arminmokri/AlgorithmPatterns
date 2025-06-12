"""
Title: First Repeated Word

Given a string containing space-separated words, return the first word that is repeated.
If there is no repetition, return an empty string.

Approach:
- Split the input string by spaces to extract individual words.
- Use a set to track seen words while iterating.
- Return the first word that is already in the set.
- If no repetition is found, return "".

Example:
Input:  "alpha beta gamma alpha delta beta"
Output: "alpha"
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

    def Solution(self, string: str) -> str:

        firstRepeated = None

        words = string.split()

        repeated = set()

        for word in words:
            word = word.strip()
            if word in repeated:
                firstRepeated = word
                break
            repeated.add(word)


        return firstRepeated



def main():
    string = "alpha beta gamma alpha delta beta"
    solution = Solution()
    result = solution.Solution(string)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
