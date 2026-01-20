[< Back To Algorithm Patterns](../../../../)

# Binary Search Algorithm Patterns
### Please support my repo with your ⭐

## Concept

Binary Search is a divide-and-conquer algorithm that reduces a search space by half on every step.  
Instead of scanning linearly in **O(n)**, it locates answers in **O(log n)** time by exploiting **monotonic structure**.

Binary Search is not only for finding values in arrays — it is a **framework for solving problems that have an ordered or monotonic search space.**

## When to Use

Use Binary Search when at least one of these is true:

- The data is **sorted**
- The problem has a **monotonic condition** (true → false or false → true)
- You need to find:
  - a **value**
  - a **boundary**
  - a **minimum / maximum / peak**
  - the **first valid answer**


## The Three Binary Search Patterns

Binary Search has **three mathematically distinct templates**.  
Mixing rules between them is the #1 cause of bugs.

# 🅰 Pattern A — Value Search (Closed Interval)

### Use When:
You want to **find a specific value**.

Examples:
- `Binary Search`
- `Search in Rotated Sorted Array`
- `Search a value in sorted array`

### Interval
`[left, right]` (both inclusive)

### Template
```java
int left = 0, right = nums.length - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;

    if (nums[mid] == target)
        return mid;
    else if (nums[mid] < target)
        left = mid + 1;
    else
        right = mid - 1;
}

return -1;
```

### Key Rule
`mid` is always tested and discarded.

# 🅱 Pattern B — Boundary Search (Half-Open Interval)

### Use When:
You want to find where something starts or stops.

Examples:
- `Search Insert Position`
- `First ≥ target`
- `Last ≤ target`
- `Lower Bound / Upper Bound`
- `First Bad Version`

### Interval
`[left, right)`

### Template
```java
int left = 0, right = nums.length;

while (left < right) {
    int mid = left + (right - left) / 2;

    if (nums[mid] < target)
        left = mid + 1;
    else
        right = mid;     // keep mid
}

return left;
```

### Key Rule
`mid` is kept when it may be the answer.

# 🅲 Pattern C — Window Shrinking (Min / Max / Peak)

### Use When:
You are searching for a position, not a value.

Examples:
- `Find Minimum in Rotated Sorted Array`
- `Find Peak Element`
- `Mountain Array`
- `Maximum / Minimum of function`

### Interval
`[left, right]` but answer always stays inside.

### Template
```java
int left = 0, right = nums.length - 1;

while (left < right) {
    int mid = left + (right - left) / 2;

    if (nums[mid] > nums[right])
        left = mid + 1;
    else
        right = mid;   // mid may be answer
}

return nums[left];
```

### With Duplicates
```java
if (nums[mid] == nums[right])
    right--;
```

## Problem → Pattern Mapping

| Problem                        | Pattern |
|--------------------------------|---------|
| Binary Search                  | A       |
| Search in Rotated Sorted Array | A       |
| Search Insert Position         | B       |
| First / Last Occurrence        | B       |
| First Bad Version              | B       |
| Find Minimum in Rotated Array  | C       |
| Find Peak Element              | C       |
| Mountain Array                 | C       |

## Important Rule
> **Never mix patterns.**
If you use:
- `left <= right` → you must follow **Pattern A** rules  
- `right = mid` → you must follow **Pattern B or C**  
- `right = mid - 1` → you are using **Pattern A**

Mixing these rules breaks the mathematical correctness of binary search and causes subtle bugs.

## Examples
| #  | Name                                                                                | Java | Python | Go | Link                                                                                   | Company |
|----|-------------------------------------------------------------------------------------|------|--------|----|----------------------------------------------------------------------------------------|---------|
| 1  | [Binary Search](binary_search/)                                                     | ✅   | ✅     | ❌ | [LeetCode #704](https://leetcode.com/problems/binary-search)                           |         |
| 2  | [Search Insert Position](search_insert_position/)                                   | ✅   | ✅     | ❌ | [LeetCode #35](https://leetcode.com/problems/search-insert-position)                   |         |
| 3  | [Find Minimum in Rotated Sorted Array](find_minimum_in_rotated_sorted_array/)       | ✅   | ✅     | ❌ | [LeetCode #153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array)    |         |
| 4  | [Search in Rotated Sorted Array](search_in_rotated_sorted_array/)                   | ✅   | ✅     | ❌ | [LeetCode #33](https://leetcode.com/problems/search-in-rotated-sorted-array)           |         |
| 5  | [Median of Two Sorted Arrays](median_of_two_sorted_arrays/)                         | ❌   | ❌     | ❌ | [LeetCode #4](https://leetcode.com/problems/median-of-two-sorted-arrays)               |         |
| 6  | [Find Minimum in Rotated Sorted Array II](find_minimum_in_rotated_sorted_array_ii/) | ✅   | ❌     | ❌ | [LeetCode #154](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii) |         |

<p align="center">
  <a href="../backtracking">⬅️ <strong>Backtracking</strong></a>
  🔸
  <a href="../dfs_bfs"><strong>DFS-BFS</strong> ➡️</a>
</p>

[< Back To Algorithm Patterns](../../../../)
