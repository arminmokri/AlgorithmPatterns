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


class Test(unittest.TestCase):
    def test_default_case(self):
        stack = Solution(4)

        self.assertTrue(stack.pushA(1))
        self.assertTrue(stack.pushB(7))
        self.assertTrue(stack.pushA(11))
        self.assertTrue(stack.pushB(77))
        stack.printSpace()

        self.assertFalse(stack.pushA(111))

        self.assertEqual(stack.popA(), 11)
        self.assertEqual(stack.popA(), 1)

        self.assertEqual(stack.popB(), 77)
        self.assertEqual(stack.popB(), 7)

        self.assertIsNone(stack.popA(), 7)
        self.assertIsNone(stack.popB(), 7)

        stack.printSpace()

    def test_push_and_pop_stackA(self):
        stack = Solution(5)
        self.assertTrue(stack.pushA(10))
        self.assertTrue(stack.pushA(20))
        self.assertEqual(stack.popA(), 20)
        self.assertEqual(stack.popA(), 10)
        self.assertIsNone(stack.popA())

        stack.printSpace()

    def test_push_and_pop_stackB(self):
        stack = Solution(5)
        self.assertTrue(stack.pushB(30))
        self.assertTrue(stack.pushB(40))
        self.assertEqual(stack.popB(), 40)
        self.assertEqual(stack.popB(), 30)
        self.assertIsNone(stack.popB())

        stack.printSpace()

    def test_overflow(self):
        stack = Solution(2)
        self.assertTrue(stack.pushA(1))
        self.assertTrue(stack.pushB(2))
        self.assertFalse(stack.pushA(3))
        self.assertFalse(stack.pushB(4))

        stack.printSpace()

    def test_underflow(self):
        stack = Solution(3)
        self.assertIsNone(stack.popA())
        self.assertIsNone(stack.popB())

        stack.printSpace()

    def test_full_interleaved_usage(self):
        stack = Solution(4)
        self.assertTrue(stack.pushA(1))
        self.assertTrue(stack.pushB(9))
        self.assertTrue(stack.pushA(2))
        self.assertTrue(stack.pushB(8))
        self.assertFalse(stack.pushA(3))  # Should fail — full

        self.assertEqual(stack.popA(), 2)
        self.assertEqual(stack.popA(), 1)
        self.assertIsNone(stack.popA())  # Already empty

        self.assertEqual(stack.popB(), 8)
        self.assertEqual(stack.popB(), 9)
        self.assertIsNone(stack.popB())  # Already empty

        stack.printSpace()

    def test_internal_array_integrity(self):
        stack = Solution(5)
        stack.pushA(10)
        stack.pushA(20)
        stack.pushB(30)
        stack.pushB(40)
        self.assertEqual(stack.myList[0], 10)
        self.assertEqual(stack.myList[1], 20)
        self.assertEqual(stack.myList[4], 30)
        self.assertEqual(stack.myList[3], 40)

        stack.printSpace()


def main():
    unittest.main()


if __name__ == "__main__":
    main()
