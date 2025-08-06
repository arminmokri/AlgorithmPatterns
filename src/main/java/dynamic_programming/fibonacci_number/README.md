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
