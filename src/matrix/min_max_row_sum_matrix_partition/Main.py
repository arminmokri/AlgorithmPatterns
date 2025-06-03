"""
Title: Min Max Row Sum Matrix Partition

You are given an array of integers of a non prime length. Your task is to partition the array into a matrix with 2 dimensions(rows and columns both >1) while preserving the order of the elements.
The goal is to find the matrix dimensions that minimize the maximum row sum.

You should return the matrix dimensions (n,p) that minimize the maximum row sum.

Example:
array :  [1,1,1,20,1,1,1,1,30,5,1,1].
possible matrices:

[1,1,1,20,1,1] // 25
[1,1,30,5,1,1] // 39
maximum row sum = 39

[1,1,1,20]
[1,1,1,1]
[30,5,1,1] // 37
maximum row sum = 37

[1,1,1]
[20,1,1]
[1,1,30]
[5,1,1]
maximum row sum = 32

[1,1]
[1,20]
[1,1]
[1,1]
[30,5]
[1,1]
maximum row sum = 35

the solution should be (4,3)
"""

import sys

debug = True


class Solution:
    def ListToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def SumAtoBpoint(self, myList: tuple, a: int, b: int) -> int:
        sum = 0
        for i in range(a, b):
            sum = sum + myList[i]
        return sum

    def Solution(self, numbers: tuple) -> tuple:
        number_of_rows = list()

        for i in range(2, len(numbers)):
            if len(numbers) % i == 0:
                number_of_rows.append(i)

        if debug:
            print("number_of_rows=" + self.ListToString(number_of_rows))
            print()

        n, p = 0, 0

        min = sys.maxsize
        for number_of_row in number_of_rows:
            number_of_col = int(len(numbers) / number_of_row)
            max = -sys.maxsize - 1

            if debug:
                print(
                    "number_of_row="
                    + str(number_of_row)
                    + " number_of_col="
                    + str(number_of_col)
                )

            for i in range(number_of_row):
                a = int(i * number_of_col)
                b = int((i + 1) * number_of_col)
                sum = self.SumAtoBpoint(numbers, a, b)

                if sum > max:
                    max = sum

                if debug:
                    print("sub_array=" + str(numbers[a:b]) + " sum=" + str(sum))

            if min > max:
                min = max
                n = number_of_row
                p = number_of_col

            if debug:
                print("max=" + str(max))
                print()

        if debug:
            print("min=" + str(min))

        return (n, p)


def main():
    numbers = (1, 1, 1, 20, 1, 1, 1, 1, 30, 5, 1, 1)
    solution = Solution()
    result = solution.Solution(numbers)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
