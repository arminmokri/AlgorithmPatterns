Title: Join Arbitrary Number of Strings with Dot Separator

Given any number of string arguments, return a single string by joining them with a dot (`.`) as a separator.

Approach:
- Accept a variable number of string arguments using `*args`.
- Iterate over the arguments and concatenate them into one string using dots between them.
- Return the final dot-joined string.

Note:
- This mimics the behavior of `".".join(args)` but is done manually through iteration.
- Handles any number of inputs, including just one.

Time Complexity: O(N) where N is the number of input strings.
Space Complexity: O(1) for intermediate storage (excluding input/output).

Examples:
Input:  "str1", "str2", "str3"
Output: "str1.str2.str3"

Input:  "str1", "str2", "str3", "str4", "str5"
Output: "str1.str2.str3.str4.str5"
