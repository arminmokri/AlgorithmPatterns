[< Back To Algorithm Patterns](../../)

# Binary Search Algorithm Patterns
### Please support my repo with your star.

## Concept
Binary Search is a divide-and-conquer algorithm used to efficiently find a target element in a sorted array or search space by repeatedly dividing the search interval in half. It cuts the search time from linear O(n) to logarithmic O(log n), making it a fundamental technique in computer science.

## When to Use
- When the input array or search space is sorted.
- When you need to find boundaries (first/last occurrence, min/max) or check feasibility.
- When searching in monotonic functions or answer spaces (not just arrays).

## Common Operations
- Maintaining left and right pointers to narrow the search space.
- Calculating the mid index to compare with the target.
- Adjusting pointers based on comparison (left = mid + 1, right = mid - 1).

## Examples
- [x] 1. [Binary Search](binary_search/) → [LeetCode #704](https://leetcode.com/problems/binary-search)

- [x] 2. [Search Insert Position](search_insert_position/) → [LeetCode #35](https://leetcode.com/problems/search-insert-position)

- [x] 3. [Find Minimum in Rotated Sorted Array](find_minimum_in_rotated_sorted_array/) → [LeetCode #153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array)

- [x] 4. [Search in Rotated Sorted Array](search_in_rotated_sorted_array/) → [LeetCode #33](https://leetcode.com/problems/search-in-rotated-sorted-array)

- [ ] 5. [Median of Two Sorted Arrays]() → [LeetCode #4](https://leetcode.com/problems/median-of-two-sorted-arrays)

<p align="center">
  <a href="../backtracking">⬅️ <strong>Backtracking</strong></a>
  🔸
  <a href="../dfs_bfs"><strong>DFS-BFS</strong> ➡️</a>
</p>

[< Back To Algorithm Patterns](../../)
