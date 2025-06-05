[< Back To Algorithm Patterns](../../)

# Sliding Window Algorithm Patterns
### Please support my repo with your star.

## Concept
The sliding window pattern uses a subset (or window) that moves across the data structure, typically arrays or strings, to keep track of a specific condition (like max, min, sum, or unique elements) over contiguous elements. It’s great for reducing nested loops (O(n²)) into single-pass solutions (O(n)) by efficiently expanding or shrinking the window.

## When to Use
- When you need to process contiguous subarrays or substrings.
- When tracking sums, counts, or properties within a fixed or variable-sized window.
- When optimizing for minimal/maximal subarray results without reprocessing the entire window each time.

## Common Operations
- Expanding the window by moving the right pointer forward.
- Shrinking the window by moving the left pointer when a condition is exceeded.
- Using a hashmap, set, or counter to track elements inside the window.

## Examples
- [x] 1. [Maximum Average Subarray I]() → [LeetCode #643](https://leetcode.com/problems/maximum-average-subarray-i)

- [ ] 2. [Longest Substring Without Repeating Characters]() → [LeetCode #3](https://leetcode.com/problems/longest-substring-without-repeating-characters)

- [ ] 3. [Longest Repeating Character Replacement]() → [LeetCode #424](https://leetcode.com/problems/longest-repeating-character-replacement)

- [ ] 4. [Minimum Window Substring]() → [LeetCode #76](https://leetcode.com/problems/minimum-window-substring)

- [ ] 5. [Permutation in String]() → [LeetCode #567](https://leetcode.com/problems/permutation-in-string)

- [x] 6. [Quadratic Consecutive Sequence Sum](quadratic_consecutive_sequence_sum/)
  <br>
  [`#TrendMicro`](https://trendmicro.com)

- [x] 7. [Distance Between Scrambled Programmer Words](distance_between_scrambled_programmer_words/)
  <br>
  [`#ExpediaGroup`](https://expediagroup.com)

<p align="center">
  <a href="../matrix">⬅️ <strong>Matrix</strong></a>
  🔸
  <a href="../tree_traversal"><strong>Tree Traversal</strong> ➡️</a>
</p>

[< Back To Algorithm Patterns](../../)
