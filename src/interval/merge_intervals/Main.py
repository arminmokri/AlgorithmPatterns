import unittest

debug = True


class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    # def hasOverlap(self, intervals: list[list[int]], new_interval: list[int]) -> bool:
    #     for i, interval in enumerate(intervals):
    #         if interval[0] > new_interval[1]:
    #             return i
    #         elif interval[1] > new_interval[0]:

    def merge1(self, intervals: list[list[int]]) -> list[list[int]]:
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """

        if debug:
            print("intervals=" + str(intervals))

        nonoverlap_intervals = list()

        for interval in intervals:
            if debug:
                print("interval=" + str(interval))

            flag = 0

            for nonoverlap_interval in nonoverlap_intervals:
                if debug:
                    print("nonoverlap_interval=" + str(nonoverlap_interval))

                if (
                    nonoverlap_interval[0] <= interval[0]
                    and nonoverlap_interval[1] >= interval[1]
                ):  # nonoverlap_interval=[0,3] interval=[1,2] do nothing
                    if debug:
                        print(
                            str(interval)
                            + " is already sub of "
                            + str(nonoverlap_interval)
                        )
                    pass
                    flag = 1
                elif (
                    nonoverlap_interval[0] >= interval[0]
                    and nonoverlap_interval[1] <= interval[1]
                ):  # nonoverlap_interval=[1,2] interval=[0,3] replace by new
                    if debug:
                        print(
                            str(interval)
                            + " is already sub of "
                            + str(nonoverlap_interval)
                        )
                    pass
                elif (
                    nonoverlap_interval[0] <= interval[0]
                    and nonoverlap_interval[1] >= interval[0]
                    and nonoverlap_interval[1] <= interval[1]
                ):  # nonoverlap_interval=[1,3] interval=[2,4] replace by merge [1,4]
                    marged_interval = [nonoverlap_interval[0], interval[1]]
                    nonoverlap_intervals.remove(nonoverlap_interval)
                    nonoverlap_intervals.append(marged_interval)
                    flag = 1
                elif (
                    nonoverlap_interval[0] >= interval[0]
                    and nonoverlap_interval[0] <= interval[1]
                    and nonoverlap_interval[1] >= interval[1]
                ):  # nonoverlap_interval=[2,4] interval=[1,3] replace by merge [1,4]
                    marged_interval = [interval[0], nonoverlap_interval[1]]
                    nonoverlap_intervals.remove(nonoverlap_interval)
                    nonoverlap_intervals.append(marged_interval)
                    print("hhh")
                    flag = 1

            if flag == 0:
                nonoverlap_intervals.append(interval)

        print("nonoverlap_intervals=" + str(nonoverlap_intervals))

        return nonoverlap_intervals

    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """

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
