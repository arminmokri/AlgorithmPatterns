Title: Distance Between Scrambled Programmer Words

You are given a string that may contain one or more disordered occurrences of the word "programmer",
possibly with other characters in between. A valid "programmer" match must contain all the letters
from the word "programmer" (with correct frequency) but can be in any order and with other characters
interspersed.

Your task is to:
1. Find the leftmost substring that contains all letters of "programmer" with correct frequency.
2. Find the rightmost such substring.
3. Return the number of characters strictly between these two matching substrings.

This is a sliding window + frequency count problem.

---

Examples:

Example 1:
Input: "progrdfammerfgfdmkjfdsprogramfertmer"
Output: 10
Explanation:
- First "programmer" match starts at index 0 (inclusive)
- Second "programmer" match ends at index 43 (inclusive)
- Characters between: from index 11 to 22 → length = 10

Example 2:
Input: "xyzprogxrammerabcprogrammer123"
Output: 3
Explanation:
- First "programmer" match from index 3 to 14
- Second "programmer" match from index 18 to 29
- Characters between: from index 13 to 17 → "abc" → length = 3

Example 3:
Input: "ppprrrooggrraammmeerr"
Output: 0
Explanation:
Only one "programmer" match is present → return 0 (nothing in between)

Example 4:
Input: "somethingrandom"
Output: 0
Explanation:
"programmer" never fully appears → return 0

Constraints:
- The input string may contain lowercase letters and symbols.
- Must handle large strings efficiently.
