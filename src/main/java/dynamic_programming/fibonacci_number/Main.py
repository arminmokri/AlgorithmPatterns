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

    # Time Complexity O(2^n), Space Complexity O(n)
    def fibonacciNumberA(self, N: int) -> int:
        if debug:
            print()

        def backtracking(num):
            if num == 0:
                return 0
            elif num == 1:
                return 1
            else:
                return backtracking(num - 1) + backtracking(num - 2)

        return backtracking(N)

    # Time Complexity O(n), Space Complexity O(1)
    def fibonacciNumberB(self, N: int) -> int:
        if debug:
            print()

        # a b
        # | |
        # 0 1 1 2 3 5 8 13 21 ....

        a = 0
        b = 1
        for i in range(N):
            next = a + b
            a = b
            b = next
        return a


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.fibonacciNumberB(0), 0)
        self.assertEqual(self.solution.fibonacciNumberB(1), 1)
        self.assertEqual(self.solution.fibonacciNumberB(2), 1)
        self.assertEqual(self.solution.fibonacciNumberB(3), 2)
        self.assertEqual(self.solution.fibonacciNumberB(4), 3)

    def test_fib_zero(self):
        self.assertEqual(self.solution.fibonacciNumberB(0), 0)

    def test_fib_one(self):
        self.assertEqual(self.solution.fibonacciNumberB(1), 1)

    def test_fib_two(self):
        self.assertEqual(self.solution.fibonacciNumberB(2), 1)

    def test_fib_five(self):
        self.assertEqual(self.solution.fibonacciNumberB(5), 5)

    def test_fib_ten(self):
        self.assertEqual(self.solution.fibonacciNumberB(10), 55)

    def test_fib_large(self):
        self.assertEqual(self.solution.fibonacciNumberB(55), 139583862445)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
