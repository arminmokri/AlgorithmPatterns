"""
Title: Two Stacks In An Array

This data structure implements two separate stacks (A and B) using a single shared list.
Stack A grows from the start (index 0) toward the end,
Stack B grows from the end (last index) toward the beginning.

Methods:
- pushA(x): Pushes an element onto Stack A.
- popA(): Pops and returns the top of Stack A. Returns None if empty.
- pushB(x): Pushes an element onto Stack B.
- popB(): Pops and returns the top of Stack B. Returns None if empty.

This avoids wasting space by maximizing the use of a single array.
"""

debug = True


class Solution:
    def martixToString(self, myMatrix: list[list] | tuple[tuple]) -> str:
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

    def listToString(self, myList: list | tuple) -> str:
        if myList == []:
            return "[]"

        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def __init__(self, size: int):
        self.size = size
        self.pointerA = -1
        self.pointerB = size
        self.myList = [None] * size

    def pushA(self, val: int) -> bool:
        if self.pointerA + 1 < self.pointerB:
            self.pointerA = self.pointerA + 1
            self.myList[self.pointerA] = val
            return True
        else:
            return False

    def popA(self) -> int:
        val = None
        if self.pointerA >= 0:
            val = self.myList[self.pointerA]
            self.myList[self.pointerA] = None
            self.pointerA = self.pointerA - 1
        return val

    def pushB(self, val) -> bool:
        if self.pointerB - 1 > self.pointerA:
            self.pointerB = self.pointerB - 1
            self.myList[self.pointerB] = val
            return True
        else:
            return False

    def popB(self) -> int:
        val = None
        if self.pointerB < self.size:
            val = self.myList[self.pointerB]
            self.myList[self.pointerB] = None
            self.pointerB = self.pointerB + 1
        return val

    def printSpace(self):
        print(
            "pointerA="
            + str(self.pointerA)
            + " pointerB="
            + str(self.pointerB)
            + " myList="
            + self.listToString(self.myList)
        )


def main():
    solution = Solution(4)

    solution.printSpace()

    solution.pushA(1)
    solution.pushB(7)
    solution.pushA(11)
    solution.pushB(77)
    solution.printSpace()

    solution.pushA(111)
    solution.printSpace()

    print(solution.popA())
    print(solution.popA())

    print(solution.popB())
    print(solution.popB())

    solution.printSpace()

    print(solution.popA())
    print(solution.popB())

    solution.printSpace()


if __name__ == "__main__":
    main()
