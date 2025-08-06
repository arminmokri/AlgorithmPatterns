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

func TestDefaultCase(t *testing.T) {
	checkResult(t, firstMissingPositive([]int{3, 4, -1, 1}), 2, "Default case 1 failed")
	checkResult(t, firstMissingPositive([]int{1, 2, 3, 4, 5, 10}), 6, "Default case 2 failed")
	checkResult(t, firstMissingPositive([]int{-1, -3}), 1, "Default case 3 failed")
}

func TestAllPositiveConsecutive(t *testing.T) {
	checkResult(t, firstMissingPositive([]int{1, 2, 3}), 4, "All positive consecutive case failed")
}

func TestMixedWithNegatives(t *testing.T) {
	checkResult(t, firstMissingPositive([]int{7, 8, 9, 11, 12}), 1, "Mixed with negatives case failed")
}

func TestUnsortedWithGap(t *testing.T) {
	checkResult(t, firstMissingPositive([]int{2, 1, 0}), 3, "Unsorted with gap case failed")
}

func TestAllNegatives(t *testing.T) {
	checkResult(t, firstMissingPositive([]int{-1, -2, -3}), 1, "All negatives case failed")
}

func TestWithZero(t *testing.T) {
	checkResult(t, firstMissingPositive([]int{0, 2, 2, 1, 1}), 3, "With zero case failed")
}

func TestEmptyList(t *testing.T) {
	checkResult(t, firstMissingPositive([]int{}), 1, "Empty list case failed")
}

func TestLargeInputGapAtBeginning(t *testing.T) {
	checkResult(t, firstMissingPositive([]int{10, 12, 11}), 1, "Large input gap at beginning case failed")
}
