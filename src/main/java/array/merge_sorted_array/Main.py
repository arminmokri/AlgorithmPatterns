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

    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if debug:
            print()

        for _ in range(len(nums1) - m):
            nums1.pop()

        if debug:
            print("nums1=" + str(nums1) + " num2=" + str(nums2))

        pm = 0
        pn = 0
        for i in range(m + n):
            if debug:
                print("i=" + str(i) + " pm=" + str(pm) + " pn=" + str(pn))

            if pn < n and pm + 1 >= len(nums1):
                nums1.append(nums2[pn])
                pn = pn + 1
                pm = pm + 1
            elif pn < n and nums1[pm] >= nums2[pn]:
                nums1.insert(pm, nums2[pn])
                pn = pn + 1
                pm = pm + 1
            elif pm < len(nums1):
                pm = pm + 1

            if debug:
                print("nums1" + str(nums1))


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        nums1 = [1, 2, 3, 0, 0, 0]
        m = 3
        nums2 = [2, 5, 6]
        n = 3
        self.solution.merge(nums1, m, nums2, n)
        self.assertEqual(nums1, [1, 2, 2, 3, 5, 6])

        nums1 = [1]
        m = 1
        nums2 = []
        n = 0
        self.solution.merge(nums1, m, nums2, n)
        self.assertEqual(nums1, [1])

        nums1 = [0]
        m = 0
        nums2 = [1]
        n = 1
        self.solution.merge(nums1, m, nums2, n)
        self.assertEqual(nums1, [1])

    def test_all_zero_in_nums1(self):
        nums1 = [0, 0, 0]
        m = 0
        nums2 = [2, 4, 6]
        n = 3
        self.solution.merge(nums1, m, nums2, n)
        self.assertEqual(nums1, [2, 4, 6])

    def test_reverse_sorted(self):
        nums1 = [4, 5, 6, 0, 0, 0]
        m = 3
        nums2 = [1, 2, 3]
        n = 3
        self.solution.merge(nums1, m, nums2, n)
        self.assertEqual(nums1, [1, 2, 3, 4, 5, 6])

    def test_with_duplicates(self):
        nums1 = [1, 1, 1, 0, 0, 0]
        m = 3
        nums2 = [1, 1, 1]
        n = 3
        self.solution.merge(nums1, m, nums2, n)
        self.assertEqual(nums1, [1, 1, 1, 1, 1, 1])


def main():
    unittest.main()


if __name__ == "__main__":
    main()
