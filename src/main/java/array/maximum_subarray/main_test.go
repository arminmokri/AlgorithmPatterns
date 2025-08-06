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

func TestMaxSubArrayDefaultCase(t *testing.T) {
	checkResult(t, maxSubArray([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6, "Default case 1 failed")
	checkResult(t, maxSubArray([]int{1}), 1, "Default case 2 failed")
	checkResult(t, maxSubArray([]int{5, 4, -1, 7, 8}), 23, "Default case 3 failed")
}

func TestMaxSubArrayAllNegative(t *testing.T) {
	checkResult(t, maxSubArray([]int{-1, -2, -3, -4}), -1, "All negative case failed")
}

func TestMaxSubArrayAllPositive(t *testing.T) {
	checkResult(t, maxSubArray([]int{1, 2, 3, 4, 5}), 15, "All positive case failed")
}

func TestMaxSubArraySingleElement(t *testing.T) {
	checkResult(t, maxSubArray([]int{-100}), -100, "Single element negative case failed")
	checkResult(t, maxSubArray([]int{0}), 0, "Single element zero case failed")
	checkResult(t, maxSubArray([]int{100}), 100, "Single element positive case failed")
}

func TestMaxSubArrayMixedWithZeroes(t *testing.T) {
	checkResult(t, maxSubArray([]int{-2, 0, -1}), 0, "Mixed with zeroes case failed")
}

func TestMaxSubArrayLargeInput(t *testing.T) {
	largeInput := make([]int, 10000)
	for i := range largeInput {
		largeInput[i] = 1
	}
	checkResult(t, maxSubArray(largeInput), 10000, "Large input case failed")
}

func TestMaxSubArrayMaxAtEnd(t *testing.T) {
	checkResult(t, maxSubArray([]int{-3, -2, 5, 6}), 11, "Max at end case failed")
}

func TestMaxSubArrayMaxAtStart(t *testing.T) {
	checkResult(t, maxSubArray([]int{10, -1, -2, -3}), 10, "Max at start case failed")
}

func TestMaxSubArrayMaxInMiddle(t *testing.T) {
	checkResult(t, maxSubArray([]int{-5, 4, -1, 2, 1, -5}), 6, "Max in middle case failed")
}

func TestMaxSubArrayMultipleSameMaxSubarrays(t *testing.T) {
	checkResult(t, maxSubArray([]int{1, -1, 1, -1, 1}), 1, "Multiple same max subarrays case failed")
}
