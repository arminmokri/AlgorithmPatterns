"""
Title: Compute Fibonacci (Iterative DP)

Description:
The goal is to compute the nth Fibonacci number without using recursion.
The Fibonacci sequence is defined as:
    F(0) = 0
    F(1) = 1
    F(n) = F(n-1) + F(n-2) for n > 1

Instead of using recursion (which has exponential time complexity due to overlapping subproblems),
this approach uses a bottom-up dynamic programming method (iterative) which computes the result in O(n) time
and O(1) space using just two variables to store previous values.
"""

debug = True

class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    # Time Complexity O(2^n), Space Complexity O(n)
    def solutionA(self, N: int) -> int:
        if N == 0:
            return 0
        elif N == 1:
            return 1
        else:
            return self.solutionA(N-1) + self.solutionA(N-2)

    # Time Complexity O(n), Space Complexity O(1)
    def solutionB(self, N: int) -> int:
        # a b
        # | |
        # 0 1 1 2 3 5 8 13 21 ....

        a = 0
        b = 1
        for i in range(N):
            next = a + b
            a = b
            b = next
        return a


def main():
    N = 55
    solution = Solution()
    result = solution.solutionB(N)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
