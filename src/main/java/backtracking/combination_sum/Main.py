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

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if debug:
            print()

        res = []
        counter = 0

        def make_combination(idx, comb: List[int], total):
            nonlocal counter
            s = (
                "counter="
                + str(counter)
                + " idx="
                + str(idx)
                + " comb="
                + str(comb)
                + " total="
                + str(total)
            )

            counter = counter + 1

            if total == target:
                res.append(comb[:])
                if debug:
                    print(s + "  (fine total - backtracking)")
                return

            if total > target or idx >= len(candidates):
                if debug:
                    print(s + " (large total - backtracking)")
                return

            if debug:
                print(s)

            comb.append(candidates[idx])
            make_combination(idx, comb, total + candidates[idx])
            
            comb.pop()
            make_combination(idx + 1, comb, total)

            return res

        return make_combination(0, [], 0)


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.combinationSum([2, 3, 6, 7], 7),
            [[2, 2, 3], [7]],
        )

        # self.assertEqual(
        #     self.solution.combinationSum([2, 3, 5], 8),
        #     [[2, 2, 2, 2], [2, 3, 3], [3, 5]],
        # )

        # self.assertEqual(
        #     self.solution.combinationSum([2], 1),
        #     [],
        # )


def main():
    unittest.main()


if __name__ == "__main__":
    main()
