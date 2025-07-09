package main

import (
	"fmt"
	"testing"
)

func checkResult[T comparable](t *testing.T, got T, want T, message string, args ...any) {
	t.Helper()
	if got != want {
		t.Errorf("%s: got = %v, want = %v", fmt.Sprintf(message, args...), got, want)
	}
}

func TestLongestCommonPrefixDefaultCase(t *testing.T) {
	checkResult(t, longestCommonPrefix([]string{"flower", "flow", "flight"}), "fl", "Default case 1 failed")
	checkResult(t, longestCommonPrefix([]string{"dog", "racecar", "car"}), "", "Default case 2 failed")
}

func TestLongestCommonPrefixSingleWord(t *testing.T) {
	checkResult(t, longestCommonPrefix([]string{"alone"}), "alone", "Single word case failed")
}

func TestLongestCommonPrefixIdenticalWords(t *testing.T) {
	checkResult(t, longestCommonPrefix([]string{"same", "same", "same"}), "same", "Identical words case failed")
}

func TestLongestCommonPrefixEmptyList(t *testing.T) {
	checkResult(t, longestCommonPrefix([]string{}), "", "Empty list case failed")
}

func TestLongestCommonPrefixListWithEmptyString(t *testing.T) {
	checkResult(t, longestCommonPrefix([]string{"", "abc", "ab"}), "", "List with empty string case failed")
}

func TestLongestCommonPrefixNoCommonPrefix(t *testing.T) {
	checkResult(t, longestCommonPrefix([]string{"abc", "def", "ghi"}), "", "No common prefix case failed")
}

func TestLongestCommonPrefixFullPrefixMatch(t *testing.T) {
	checkResult(t, longestCommonPrefix([]string{"interview", "intervene", "internal"}), "inter", "Full prefix match case failed")
}

func TestLongestCommonPrefixNumericStringPrefix(t *testing.T) {
	checkResult(t, longestCommonPrefix([]string{"12345", "123", "123abc"}), "123", "Numeric string prefix case failed")
}

func TestLongestCommonPrefixCaseSensitive(t *testing.T) {
	checkResult(t, longestCommonPrefix([]string{"Case", "case", "cast"}), "", "Case sensitive case failed")
}
