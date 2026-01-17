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

    def coinChange(self, coins: List[int], amount: int) -> int:
        if debug:
            print()

        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        if debug:
            print("dp=" + self.listToString(dp))

        for i in range(len(coins)):
            coin = coins[i]
            for j in range(coin, len(dp)):
                dp[j] = min(dp[j], dp[j - coin] + 1)

            if debug:
                print("coin=" + str(coin) + " dp=" + self.listToString(dp))

        return dp[amount] if dp[amount] != (amount + 1) else -1


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.coinChange([1, 2, 5], 11), 3)
        self.assertEqual(self.solution.coinChange([2], 3), -1)
        self.assertEqual(self.solution.coinChange([1], 0), 0)

    def test_single_coin_exact_match(self):
        self.assertEqual(self.solution.coinChange([5], 5), 1)

    def test_single_coin_no_match(self):
        self.assertEqual(self.solution.coinChange([3], 2), -1)

    def test_multiple_coins(self):
        self.assertEqual(self.solution.coinChange([2, 3, 6], 7), 3)  # 3 + 2 + 2 = 7
        self.assertEqual(self.solution.coinChange([2, 3, 6, 7], 7), 1)  # 7

    def test_large_amount(self):
        self.assertEqual(self.solution.coinChange([1, 2, 5], 100), 20)  # 20 coins of 5

    def test_large_coin_small_amount(self):
        self.assertEqual(self.solution.coinChange([100], 1), -1)

    def test_empty_coin_list(self):
        self.assertEqual(self.solution.coinChange([], 7), -1)

    def test_zero_amount(self):
        self.assertEqual(self.solution.coinChange([1, 2, 5], 0), 0)

    def test_duplicate_coins(self):
        self.assertEqual(self.solution.coinChange([1, 1, 2, 2, 5], 11), 3)

    def test_unreachable_amount(self):
        self.assertEqual(self.solution.coinChange([2, 4], 7), -1)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
