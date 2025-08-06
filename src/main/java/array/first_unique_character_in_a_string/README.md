Title: First Unique Character in a String

Given a string, return the index of the first non-repeating (unique) character.
If there is no such character, return None (or -1 based on design preference).

Approach:
- Initialize a frequency list of size 256 to count occurrences of each ASCII character.
- Traverse the string and update the frequency of each character using its ASCII value.
- Traverse the string again to find the first character with a frequency of 1.
- Return the index of this unique character.
- If no unique character is found, return None.

Example:
Input:  "stress"
Output: 1  # 't' is the first non-repeating character
