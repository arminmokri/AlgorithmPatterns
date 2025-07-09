Title: Quadratic Consecutive Sequence Sum

Given an integer `x`, find all sequences of the form:
    n^2 + (n+1)^2 + (n+2)^2 + ... + (n+m)^2 = x
Return all possible values of `n` where the equation holds for some m >= 0.

Input:
    - A single integer x (1 <= x <= 10^9)

Output:
    - An array of strings:
        - First element: "count: <number of valid sequences>"
        - Next lines: space-separated sequences of values (e.g., "3 4 5")

Example 1:
Input: 2030
Output:
[
    "count: 2",
    "21 22 23 24",   # 21^2 + 22^2 + 23^2 + 24^2 = 2030
    "25 26 27"       # 25^2 + 26^2 + 27^2 = 2030
]

Example 2:
Input: 50
Output:
[
    "count: 2",
    "3 4 5"          # 3^2 + 4^2 + 5^2 = 9 + 16 + 25 = 50
]

Example 3:
Input: 365
Output:
[
    "count: 2",
    "10 11 12",
    "13 14"
]
