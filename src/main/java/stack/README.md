[< Back To Algorithm Patterns](../../../../)

# Stack Algorithm Patterns
### Please support my repo with your ⭐

## Concept
The Stack pattern is based on the **Last-In-First-Out (LIFO)** principle and is used to process elements in a controlled order, often when the most recent element affects the next decision. Stack-based problems typically involve matching, reversing, validating, or maintaining a monotonic order, making stacks ideal for parsing expressions, handling nested structures, and solving “previous/next greater” type problems.

## When to Use
- When the problem involves **nested structures** (parentheses, brackets, scopes).
- When you need to **undo or rollback** previous operations.
- When tracking **previous or next greater/smaller elements**.
- When order matters and **recent elements influence current logic**.

## Common Operations
- `push` and `pop` elements based on conditions.
- Using a **monotonic stack** (increasing or decreasing).
- Storing indices instead of values to compute distances or ranges.
- Simulating recursion or state using an explicit stack.

## Examples
| #  | Name                                              | Java | Python | Go | Link                                                                  | Company |
|----|---------------------------------------------------|------|--------|----|-----------------------------------------------------------------------|---------|
| 1  | [Next Greater Element I](next_greater_elementـi/) | ✅   | ❌     | ❌ | [LeetCode #496](https://leetcode.com/problems/next-greater-element-i) |         |

<p align="center">
  <a href="../sliding_window">⬅️ <strong>Sliding Window</strong></a>
  🔸
  <a href="../tree_traversal"><strong>Tree Traversal</strong> ➡️</a>
</p>

[< Back To Algorithm Patterns](../../../../)
