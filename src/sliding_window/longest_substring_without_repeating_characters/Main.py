import unittest
import sys

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

    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        :type s: str
        :rtype: int
        """
        if debug:
            print()

        def hasDuplicate(sub_string: str) -> bool:
            frequency = set()
            has_duplicate = False
            for _, c in enumerate(sub_string):
                if c in frequency:
                    has_duplicate = True
                else:
                    frequency.add(c)
            return has_duplicate

        max_sub_string = 0

        for i in range(len(s)):
            for j in range(i, len(s)):
                sub_string = s[i : j + 1]
                if len(sub_string) > max_sub_string and not hasDuplicate(sub_string):
                    max_sub_string = len(sub_string)
                print(sub_string)

        return max_sub_string


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring("abcabcbb"), 3)
        self.assertEqual(self.solution.lengthOfLongestSubstring("bbbbb"), 1)
        self.assertEqual(self.solution.lengthOfLongestSubstring("pwwkew"), 3)

    def test_empty_string(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring(""), 0)

    def test_all_unique(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring("abcdef"), 6)

    def test_all_same_char(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring("aaaaaa"), 1)

    def test_substring_at_end(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring("abcdeabcdefg"), 7)

    def test_numbers_and_symbols(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring("1234567890!@#"), 13)

    def test_repeating_patterns(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring("abababab"), 2)

    def test_mixed_case(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring("aAbBcC"), 6)

    def test_unicode(self):
        self.assertEqual(self.solution.lengthOfLongestSubstring("🙂🙃🙂🙃"), 2)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
