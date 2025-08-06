from typing import List, Tuple
import unittest

debug = True


class Solution:
    def martixToString(self, myMatrix: List[List] | Tuple[Tuple]) -> str:
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

    def maxProfit(self, prices: List[int]) -> int:
        if debug:
            print()

        if debug:
            print("prices=" + str(prices))

        buy_price = prices[0] if len(prices) > 0 else 0
        profit = 0

        for i in range(1, len(prices)):
            buy_price = min(buy_price, prices[i])
            profit = max(profit, prices[i] - buy_price)

        return profit


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.maxProfit([7, 1, 5, 3, 6, 4]), 5)
        self.assertEqual(self.solution.maxProfit([7, 6, 4, 3, 1]), 0)

    def test_edge_case_empty_list(self):
        self.assertEqual(self.solution.maxProfit([]), 0)

    def test_edge_case_single_element(self):
        self.assertEqual(self.solution.maxProfit([10]), 0)

    def test_edge_case_two_elements_profit(self):
        self.assertEqual(self.solution.maxProfit([1, 10]), 9)

    def test_edge_case_two_elements_loss(self):
        self.assertEqual(self.solution.maxProfit([10, 1]), 0)

    def test_constant_prices(self):
        self.assertEqual(self.solution.maxProfit([5, 5, 5, 5]), 0)

    def test_early_low_late_high(self):
        self.assertEqual(self.solution.maxProfit([1, 2, 90, 10, 5]), 89)

    def test_large_jump_at_end(self):
        self.assertEqual(self.solution.maxProfit([5, 4, 3, 2, 100]), 98)

    def test_multiple_opportunities(self):
        self.assertEqual(self.solution.maxProfit([3, 2, 6, 1, 4]), 4)

    def test_price_dips_before_rise(self):
        self.assertEqual(self.solution.maxProfit([2, 1, 2, 1, 2]), 1)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
