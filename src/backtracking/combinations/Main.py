import unittest

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

    def combine(self, n: int, k: int) -> list[list[int]]:
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """

        if debug:
            print()

        if debug:
            print(str([p for p in range(1, n + 1)]))

        combines = list()
        combine = list()

        def backtrack(start):
            if len(combine) == k:
                combines.append(combine[:])
                return

            for num in range(start, n + 1):
                combine.append(num)
                backtrack(num + 1)
                combine.pop()

        backtrack(1)

        print("combines=" + str(combines))

        return combines


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.combine(4, 2),
            [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]],
        )

        self.assertEqual(self.solution.combine(1, 1), [[1]])

    def test_k_equals_0(self):
        self.assertEqual(self.solution.combine(5, 0), [[]])

    def test_k_greater_than_n(self):
        self.assertEqual(self.solution.combine(3, 4), [])

    def test_n_equals_0(self):
        self.assertEqual(self.solution.combine(0, 0), [[]])
        self.assertEqual(self.solution.combine(0, 1), [])

    def test_n_equals_k(self):
        self.assertEqual(self.solution.combine(3, 3), [[1, 2, 3]])

    def test_large_input(self):
        result = self.solution.combine(5, 3)
        expected = [
            [1, 2, 3],
            [1, 2, 4],
            [1, 2, 5],
            [1, 3, 4],
            [1, 3, 5],
            [1, 4, 5],
            [2, 3, 4],
            [2, 3, 5],
            [2, 4, 5],
            [3, 4, 5],
        ]
        self.assertEqual(sorted(result), sorted(expected))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
