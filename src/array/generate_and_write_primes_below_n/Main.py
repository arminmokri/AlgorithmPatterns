from typing import List, Tuple
import unittest
import tempfile
import os
import math

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

    def isPrime(self, number: int) -> bool:
        flag = 0
        for i in range(2, int(math.sqrt(number)) + 1):
            if number % i == 0:
                flag = 1
                break

        return flag == 0

    def generatePrimesBelowN(self, N: int, filePath: str) -> List:
        if debug:
            print()

        primeList = list()

        for i in range(2, N):
            if self.isPrime(i):
                primeList.append(i)

        if debug:
            print(primeList)

        with open(filePath, "w") as f:
            f.write("{}\n".format(primeList))

        return primeList


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        with tempfile.NamedTemporaryFile(
            delete=False, mode="r+", suffix=".txt"
        ) as tmp_file:
            expected = [
                2,
                3,
                5,
                7,
                11,
                13,
                17,
                19,
                23,
                29,
                31,
                37,
                41,
                43,
                47,
                53,
                59,
                61,
                67,
                71,
                73,
                79,
                83,
                89,
                97,
            ]
            result = self.solution.generatePrimesBelowN(100, tmp_file.name)
            self.assertEqual(result, expected)

            tmp_file.seek(0)
            file_content = tmp_file.read()
            self.assertIn("2", file_content)
            self.assertIn("7", file_content)
            self.assertTrue(file_content.startswith("["))

        os.remove(tmp_file.name)

    def test_primes_below_10(self):
        with tempfile.NamedTemporaryFile(
            delete=False, mode="r+", suffix=".txt"
        ) as tmp_file:
            expected = [2, 3, 5, 7]
            result = self.solution.generatePrimesBelowN(10, tmp_file.name)
            self.assertEqual(result, expected)

            tmp_file.seek(0)
            file_content = tmp_file.read()
            self.assertIn("2", file_content)
            self.assertIn("7", file_content)
            self.assertTrue(file_content.startswith("["))

        os.remove(tmp_file.name)

    def test_primes_below_2(self):
        with tempfile.NamedTemporaryFile(
            delete=False, mode="r+", suffix=".txt"
        ) as tmp_file:
            expected = []
            result = self.solution.generatePrimesBelowN(2, tmp_file.name)
            self.assertEqual(result, expected)

            tmp_file.seek(0)
            file_content = tmp_file.read()
            self.assertEqual(file_content.strip(), "[]")

        os.remove(tmp_file.name)

    def test_file_written(self):
        with tempfile.NamedTemporaryFile(
            delete=False, mode="r+", suffix=".txt"
        ) as tmp_file:
            self.solution.generatePrimesBelowN(20, tmp_file.name)

            tmp_file.seek(0)
            content = tmp_file.read()
            self.assertTrue("13" in content)
            self.assertTrue("19" in content)

        os.remove(tmp_file.name)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
