from typing import List, Tuple
import unittest
import sys

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

    def SumAtoBpoint(self, myList: Tuple, a: int, b: int) -> int:
        sum = 0
        for i in range(a, b):
            sum = sum + myList[i]
        return sum

    def minMaxRowSumMatrixPartition(self, numbers: Tuple) -> Tuple:
        if debug:
            print()

        number_of_rows = list()

        for i in range(2, len(numbers)):
            if len(numbers) % i == 0:
                number_of_rows.append(i)

        if debug:
            print("number_of_rows=" + self.listToString(number_of_rows))
            print()

        n, p = 0, 0

        min = sys.maxsize
        for number_of_row in number_of_rows:
            number_of_col = int(len(numbers) / number_of_row)
            max = -sys.maxsize - 1

            if debug:
                print(
                    "number_of_row="
                    + str(number_of_row)
                    + " number_of_col="
                    + str(number_of_col)
                )

            for i in range(number_of_row):
                a = int(i * number_of_col)
                b = int((i + 1) * number_of_col)
                sum = self.SumAtoBpoint(numbers, a, b)

                if sum > max:
                    max = sum

                if debug:
                    print("sub_array=" + str(numbers[a:b]) + " sum=" + str(sum))

            if min > max:
                min = max
                n = number_of_row
                p = number_of_col

            if debug:
                print("max=" + str(max))
                print()

        if debug:
            print("min=" + str(min))

        return (n, p)


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.minMaxRowSumMatrixPartition(
                (1, 1, 1, 20, 1, 1, 1, 1, 30, 5, 1, 1)
            ),
            (4, 3),
        )

    def test_all_ones(self):
        self.assertEqual(
            self.solution.minMaxRowSumMatrixPartition((1, 1, 1, 1, 1, 1, 1, 1)), (4, 2)
        )

    def test_two_possible_shapes(self):
        self.assertEqual(
            self.solution.minMaxRowSumMatrixPartition((10, 20, 30, 40, 50, 60)), (3, 2)
        )

    def test_larger_values_middle(self):
        self.assertEqual(
            self.solution.minMaxRowSumMatrixPartition(
                (1, 1, 100, 1, 1, 1, 100, 1, 1, 1, 100, 1)
            ),
            (6, 2),
        )

    def test_decreasing_sequence(self):
        self.assertEqual(
            self.solution.minMaxRowSumMatrixPartition(
                (12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
            ),
            (6, 2),
        )

    def test_increasing_sequence(self):
        self.assertEqual(
            self.solution.minMaxRowSumMatrixPartition(tuple(range(1, 13))), (6, 2)
        )

    def test_symmetrical_distribution(self):
        self.assertEqual(
            self.solution.minMaxRowSumMatrixPartition(
                (1, 2, 3, 4, 100, 4, 3, 2, 1, 100, 1, 1)
            ),
            (6, 2),
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
