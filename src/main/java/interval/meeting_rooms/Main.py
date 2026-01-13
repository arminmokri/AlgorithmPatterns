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

    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        if debug:
            print()

        intervals.sort(key=lambda interval: interval[0])

        print(intervals)

        canAttendMeetings = True
        last = intervals[0] if len(intervals) > 0 else None

        for i in range(1, len(intervals)):
            interval = intervals[i]
            if last[1] > interval[0]:
                canAttendMeetings = False
                break
            last = interval

        return canAttendMeetings


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertFalse(self.solution.canAttendMeetings([[0, 30], [5, 10], [15, 20]]))
        self.assertTrue(self.solution.canAttendMeetings([[7, 10], [2, 4]]))

    def test_empty_intervals(self):
        self.assertTrue(self.solution.canAttendMeetings([])) 

    def test_single_meeting(self):
        self.assertTrue(self.solution.canAttendMeetings([[0, 10]]))  

    def test_no_overlap_sorted(self):
        self.assertTrue(self.solution.canAttendMeetings([[1, 3], [4, 6], [7, 10]]))

    def test_no_overlap_unsorted(self):
        self.assertTrue(self.solution.canAttendMeetings([[5, 6], [1, 2], [3, 4]]))

    def test_exact_touching_intervals(self):
        self.assertTrue(self.solution.canAttendMeetings([[1, 2], [2, 3], [3, 4]]))  

    def test_overlap_at_end(self):
        self.assertFalse(self.solution.canAttendMeetings([[1, 4], [2, 5]]))  

    def test_large_input(self):
        intervals = [[i, i + 1] for i in range(0, 10000, 2)]
        self.assertTrue(self.solution.canAttendMeetings(intervals))

    def test_zero_length_meeting(self):
        self.assertTrue(self.solution.canAttendMeetings([[1, 1], [2, 3]])) 

    def test_duplicate_meetings(self):
        self.assertFalse(self.solution.canAttendMeetings([[1, 3], [1, 3]])) 

def main():
    unittest.main()


if __name__ == "__main__":
    main()
