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

    def insert(
        self, intervals: list[list[int]], newInterval: list[int]
    ) -> list[list[int]]:
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """

        if debug:
            print()

        if debug:
            print("newInterval=" + str(newInterval) + " intervals=" + str(intervals))

        new_intervals = list()

        i = 0
        while i < len(intervals) and intervals[i][1] < newInterval[0]:
            interval = intervals[i]
            new_intervals.append(interval)
            i = i + 1
            if debug:
                print("before start collision - add interval=" + str(interval))

        while i < len(intervals) and intervals[i][0] <= newInterval[1]:
            interval = intervals[i]
            newInterval[0] = min(newInterval[0], interval[0])
            newInterval[1] = max(newInterval[1], interval[1])
            i = i + 1
            if debug:
                print("in the collision - update newInterval=" + str(newInterval))

        new_intervals.append(newInterval)
        if debug:
            print("in the collision - add newInterval=" + str(newInterval))

        while i < len(intervals):
            interval = intervals[i]
            new_intervals.append(interval)
            i = i + 1
            if debug:
                print("after collision ends - add interval=" + str(interval))

        if debug:
            print("new_intervals=" + str(new_intervals))

        return new_intervals


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.insert([[1, 3], [6, 9]], [2, 5]), [[1, 5], [6, 9]]
        )

        self.assertEqual(
            self.solution.insert([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], [4, 8]),
            [[1, 2], [3, 10], [12, 16]],
        )

    def test_insert_before_all(self):
        self.assertEqual(
            self.solution.insert([[5, 7], [8, 12]], [1, 3]),
            [[1, 3], [5, 7], [8, 12]],
        )

    def test_insert_after_all(self):
        self.assertEqual(
            self.solution.insert([[1, 2], [3, 5]], [6, 8]),
            [[1, 2], [3, 5], [6, 8]],
        )

    def test_insert_overlapping_multiple(self):
        self.assertEqual(
            self.solution.insert([[1, 3], [4, 6], [7, 9]], [2, 8]),
            [[1, 9]],
        )

    def test_insert_overlapping_all(self):
        self.assertEqual(
            self.solution.insert([[2, 3], [4, 5], [6, 7]], [1, 10]),
            [[1, 10]],
        )

    def test_insert_exact_match(self):
        self.assertEqual(
            self.solution.insert([[1, 2], [3, 4]], [3, 4]),
            [[1, 2], [3, 4]],
        )

    def test_insert_into_empty_list(self):
        self.assertEqual(
            self.solution.insert([], [5, 7]),
            [[5, 7]],
        )

    def test_insert_between_non_overlapping(self):
        self.assertEqual(
            self.solution.insert([[1, 2], [8, 10]], [4, 6]),
            [[1, 2], [4, 6], [8, 10]],
        )

    def test_insert_fully_contained(self):
        self.assertEqual(
            self.solution.insert([[1, 10]], [3, 5]),
            [[1, 10]],
        )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
