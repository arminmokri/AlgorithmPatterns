from typing import List, Tuple
import unittest

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

    def arbitraryArguments(self, *strs: List[str]) -> str:
        if debug:
            print()
        res = ""
        for i in range(len(strs)):
            if i == 0:
                res = strs[i]
            else:
                res = res + "." + strs[i]

        return res


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.arbitraryArguments("str1", "str2", "str3"), "str1.str2.str3"
        )
        self.assertEqual(
            self.solution.arbitraryArguments("str1", "str2", "str3", "str4", "str5"),
            "str1.str2.str3.str4.str5",
        )

    def test_single_argument(self):
        self.assertEqual(self.solution.arbitraryArguments("only"), "only")

    def test_no_argument(self):
        self.assertEqual(self.solution.arbitraryArguments(), "")

    def test_with_empty_strings(self):
        self.assertEqual(self.solution.arbitraryArguments("", "a", ""), ".a.")

    def test_with_special_characters(self):
        self.assertEqual(
            self.solution.arbitraryArguments("a!", "@b#", "$c%"), "a!.@b#.$c%"
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
