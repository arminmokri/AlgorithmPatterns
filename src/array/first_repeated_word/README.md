Title: First Repeated Word

Given a string containing space-separated words, return the first word that is repeated.
If there is no repetition, return an empty string.

Approach:
- Split the input string by spaces to extract individual words.
- Use a set to track seen words while iterating.
- Return the first word that is already in the set.
- If no repetition is found, return "".

Example:
Input:  "alpha beta gamma alpha delta beta"
Output: "alpha"
