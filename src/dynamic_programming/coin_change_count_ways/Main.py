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

    def coinChange(self, N: int, coins: Tuple[int]) -> int:
        if debug:
            print()

        ways = [0 for _ in range(N + 1)]

        ways[0] = 1

        # print
        if debug:
            print("coins=" + self.listToString(coins))
            print()

        for i, coin in enumerate(coins):
            # print
            if debug:
                print("i=" + str(i) + " coin=" + str(coin))

            for j in range(len(ways)):
                if coin <= j:
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

        return ways[N]


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(self.solution.coinChange(12, (1, 2, 5, 10)), 15)

    def test_zero_amount(self):
        self.assertEqual(self.solution.coinChange(0, (1, 2, 5)), 1)

    def test_no_coins(self):
        self.assertEqual(self.solution.coinChange(5, ()), 0)

    def test_exact_single_coin_match(self):
        self.assertEqual(self.solution.coinChange(5, (5,)), 1)

    def test_coins_larger_than_target(self):
        self.assertEqual(self.solution.coinChange(3, (4, 5)), 0)

    def test_single_coin_multiple_ways(self):
        self.assertEqual(self.solution.coinChange(4, (1, 2)), 3)

    def test_large_target_small_coins(self):
        self.assertEqual(self.solution.coinChange(10, (1,)), 1)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
