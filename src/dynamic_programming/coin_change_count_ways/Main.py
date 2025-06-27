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

    #
    def coinChangeA(self, coins: Tuple[int], sum: int) -> int:
        if debug:
            print()

        dp = [[0] * (sum + 1) for i in range(len(coins) + 1)]

        dp[0][0] = 1

        if debug:
            print("dp=")
            print(self.martixToString(dp))

        for i in range(1, len(dp)):
            coin = coins[i - 1]
            for j in range(len(dp[0])):
                dp[i][j] = dp[i - 1][j]

                if dp[i][j - coin] >= 0:
                    dp[i][j] = dp[i][j] + dp[i][j - coin]

            if debug:
                print("dp=")
                print(self.martixToString(dp))

        return dp[len(coins)][sum]

    #
    def coinChangeB(self, coins: Tuple[int], sum: int) -> int:
        if debug:
            print()

        ways = [0 for _ in range(sum + 1)]

        ways[0] = 1

        # print
        if debug:
            print("coins=" + self.listToString(coins))
            print()

        for i, coin in enumerate(coins):
            # print
            if debug:
                print("i=" + str(i) + " coin=" + str(coin))

            for j in range(coin, len(ways)):
                # Update the ways array
                index = j - coin
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

        return ways[sum]

    def coinChange(self, coins: Tuple[int], sum: int) -> int:
        return self.coinChangeB(coins, sum)


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.coinChange([1, 2, 3], 5), 5)

    def test_large_matchs(self):
        self.assertEqual(self.solution.coinChange([1, 2, 5, 10], 12), 15)

    def test_zero_amount(self):
        self.assertEqual(self.solution.coinChange([1, 2, 5], 0), 1)

    def test_no_coins(self):
        self.assertEqual(self.solution.coinChange([], 5), 0)

    def test_exact_single_coin_match(self):
        self.assertEqual(self.solution.coinChange([5], 5), 1)

    def test_coins_larger_than_target(self):
        self.assertEqual(self.solution.coinChange([4, 5], 3), 0)

    def test_single_coin_multiple_ways(self):
        self.assertEqual(self.solution.coinChange([1, 2], 4), 3)

    def test_large_target_small_coins(self):
        self.assertEqual(self.solution.coinChange([1], 10), 1)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
