import unittest

debug = True


class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def climbStairs(self, n: int) -> int:
        """
        :type n: int
        :rtype: int
        """

        if debug:
            print()

        if debug:
            print("n=" + str(n))

        stairs = [0] * (n + 1)
        stairs[0] = 1
        stairs[1] = 1

        for i in range(2, n + 1):
            stairs[i] = stairs[i - 1] + stairs[i - 2]

        if debug:
            print(self.listToString(stairs))

        return stairs[-1]


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_basic_case(self):
        self.assertEqual(self.solution.climbStairs(2), 2)
        self.assertEqual(self.solution.climbStairs(3), 3)

    def test_min_number(self):
        self.assertEqual(self.solution.climbStairs(1), 1)

    def test_big_number(self):
        self.assertEqual(self.solution.climbStairs(50), 20365011074)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
