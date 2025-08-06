Title: Two Stacks In An Array

This data structure implements two separate stacks (A and B) using a single shared list.
Stack A grows from the start (index 0) toward the end,
Stack B grows from the end (last index) toward the beginning.

Methods:
- pushA(x): Pushes an element onto Stack A.
- popA(): Pops and returns the top of Stack A. Returns None if empty.
- pushB(x): Pushes an element onto Stack B.
- popB(): Pops and returns the top of Stack B. Returns None if empty.

This avoids wasting space by maximizing the use of a single array.
