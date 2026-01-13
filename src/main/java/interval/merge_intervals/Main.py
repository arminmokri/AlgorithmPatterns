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

    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda interval: interval[0])

        if debug:
            print()
            print("intervals=" + str(intervals))

        nonoverlap_intervals = list()
        previous = intervals[0] if len(intervals) > 0 else None

        has_overlap = lambda x, y: x[1] >= y[0]

        for i in range(1, len(intervals)):
            interval = intervals[i]

            if has_overlap(previous, interval):
                previous = [previous[0], max(previous[1], interval[1])]
            else:
                nonoverlap_intervals.append(previous)
                previous = interval

        if previous is not None:
            nonoverlap_intervals.append(previous)

        if debug:
            print("nonoverlap_intervals=" + str(nonoverlap_intervals))

        return nonoverlap_intervals


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.merge([[1, 3], [2, 6], [8, 10], [15, 18]]),
            [[1, 6], [8, 10], [15, 18]],
        )

        self.assertEqual(self.solution.merge([[1, 4], [4, 5]]), [[1, 5]])

    def test_merge_nested_intervals(self):
        self.assertEqual(self.solution.merge([[1, 7], [2, 6], [3, 5]]), [[1, 7]])
        self.assertEqual(self.solution.merge([[2, 6], [3, 5], [1, 7]]), [[1, 7]])

    def test_merge_edge_touching(self):
        self.assertEqual(self.solution.merge([[1, 2], [2, 3], [3, 4]]), [[1, 4]])

    def test_merge_non_overlapping(self):
        self.assertEqual(
            self.solution.merge([[1, 2], [3, 4], [5, 6]]), [[1, 2], [3, 4], [5, 6]]
        )

    def test_merge_single_interval(self):
        self.assertEqual(self.solution.merge([[1, 10]]), [[1, 10]])

    def test_merge_empty_list(self):
        self.assertEqual(self.solution.merge([]), [])


def main():
    unittest.main()


if __name__ == "__main__":
    main()
