"""
Title: Generate Primes Below N and Save to File

Description:
This script generates all prime numbers less than a given number N using 
the Sieve of Eratosthenes algorithm, a highly efficient method for finding
primes. The resulting prime numbers are written to a file, one per line.

Use Case:
This problem is useful for understanding number theory, prime number
generation, and efficient use of boolean arrays. It's also a practical
example of combining algorithm logic with file I/O operations in Python.

Example:
For N = 100, the script will output all prime numbers less than 100
(e.g., 2, 3, 5, ..., 97) into a file named `primes.txt`.
"""

import math

debug = True


class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def isPrime(self, number: int) -> bool:
        flag = 0
        for i in range(2, int(math.sqrt(number)) + 1):
            if number % i == 0:
                flag = 1
                break

        return flag == 0

    def Solution(self, N: int, file: str) -> list:
        primeList = list()

        for i in range(2, N):
            if self.isPrime(i):
                primeList.append(i)

        if debug:
            print(primeList)

        with open(file, "w") as f:
            f.write("{}\n".format(primeList))

        return primeList


def main():
    N = 100
    file = "/tmp/primes.txt"
    solution = Solution()
    result = solution.Solution(N, file)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
