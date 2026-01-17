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

    def combinatorialPartitioning(self, r: int, total: int) -> int:
        if debug:
            print()

        ways = [0 for _ in range(total + 1)]

        ways[0] = 1

        steps = [n for n in range(1, r + 1)]

        # print
        if debug:
            print("steps=" + self.listToString(steps))
            print()

        for i, step in enumerate(steps):
            # print
            if debug:
                print("i=" + str(i) + " step=" + str(step))

            for j in range(len(ways)):
                if step <= j:
                    # Update the ways array
                    index = j - step
                    ways[j] = ways[j] + ways[index]

                    # print
                    if debug:
                        print(
                            "j="
                            + str(j)
                            + " index="
                            + str(index)
                            + " ways="
                            + self.listToString(ways)
                        )

        # print
        if debug:
            print()

        return ways[total]


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.combinatorialPartitioning(2, 8), 5)

    def test_zero_total(self):
        self.assertEqual(self.solution.combinatorialPartitioning(5, 0), 1)

    def test_zero_range(self):
        self.assertEqual(self.solution.combinatorialPartitioning(0, 5), 0)

    def test_equal_r_and_total(self):
        self.assertEqual(self.solution.combinatorialPartitioning(4, 4), 5)

    def test_one_step_only(self):
        self.assertEqual(self.solution.combinatorialPartitioning(1, 5), 1)

    def test_total_less_than_r(self):
        self.assertEqual(self.solution.combinatorialPartitioning(10, 3), 3)

    def test_large_total(self):
        self.assertEqual(self.solution.combinatorialPartitioning(3, 10), 14)

    def test_huge_case_naive_recursion_will_timeout_or_stackoverflow(self):
        self.assertEqual(self.solution.combinatorialPartitioning(50, 100), 189_477_547)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
