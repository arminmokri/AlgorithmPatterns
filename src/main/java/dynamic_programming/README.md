[< Back To Algorithm Patterns](../../)

# Dynamic Programming Algorithm Patterns
### Please support my repo with your star.

## Concept
Dynamic Programming (DP) is a method for solving complex problems by breaking them down into simpler overlapping subproblems, storing the results of these subproblems to avoid redundant computation (memoization or tabulation). It’s typically used to optimize recursive solutions and improve time complexity by reusing previously computed results.

## When to Use
Use DP when a problem has **overlapping subproblems** and **optimal substructure**, meaning the global optimal solution can be built from optimal solutions of smaller subproblems. Common in problems involving counting, optimization, decision-making over stages, and minimizing/maximizing cost.

## Common Operations
- Defining states and transition relations
- Recursion with memoization (top-down) or iteration with tabulation (bottom-up)
- Managing base cases
- Using 1D or 2D arrays (or dictionaries) to store computed results

## Examples
| #  | Name                                                              | Java | Python | Go | Link                                                                                                                                | Company                                     |
|----|-------------------------------------------------------------------|------|--------|----|-------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------|
| 1  | [Climbing Stairs](climbing_stairs/)                               | ❌   | ✅     | ❌ | [LeetCode #70](https://leetcode.com/problems/climbing-stairs)                                                                       |                                             |
| 2  | [Longest Increasing Subsequence](longest_increasing_subsequence/) | ❌   | ✅     | ❌ | [LeetCode #300](https://leetcode.com/problems/longest-increasing-subsequence)                                                       |                                             |
| 3  | [Coin Change](coin_change/)                                       | ❌   | ✅     | ❌ | [LeetCode #322](https://leetcode.com/problems/coin-change)                                                                          |                                             |
| 4  | [House Robber](house_robber/)                                     | ❌   | ✅     | ❌ | [LeetCode #198](https://leetcode.com/problems/house-robber)                                                                         |                                             |
| 5  | [Edit Distance]()                                                 | ❌   | ❌     | ❌ | [LeetCode #72](https://leetcode.com/problems/edit-distance)                                                                         |                                             |
| 6  | [Coin Change - Count Ways To Make Sum](coin_change_count_ways/)   | ✅   | ✅     | ❌ | [GeeksforGeeks](https://www.geeksforgeeks.org/dsa/coin-change-dp-7)                                                                 |                                             |
| 7  | [Combinatorial Partitioning](combinatorial_partitioning/)         | ✅   | ✅     | ❌ |                                                                                                                                     | [`#ExpediaGroup`](https://expediagroup.com) |
| 8  | [Fibonacci Number](fibonacci_number/)                             | ✅   | ✅     | ❌ | [LeetCode #509](https://leetcode.com/problems/fibonacci-number)                                                                     | [`#Geotab`](https://geotab.com)             |
| 9  | [0/1 Knapsack](zero_one_knapsack/)                                | ❌   | ✅     | ❌ | [W3Schools](https://w3schools.com/dsa/dsa_ref_knapsack.php) / [GeeksforGeeks](https://geeksforgeeks.org/0-1-knapsack-problem-dp-10) |                                             |

<p align="center">
  <a href="../dfs_bfs">⬅️ <strong>DFS-BFS</strong></a>
  🔸
  <a href="../interval"><strong>Interval</strong> ➡️</a>
</p>

[< Back To Algorithm Patterns](../../)
