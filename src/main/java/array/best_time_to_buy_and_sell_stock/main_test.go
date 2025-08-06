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
	checkResult(t, maxProfit([]int{7, 1, 5, 3, 6, 4}), 5, "Default case 1 failed")
	checkResult(t, maxProfit([]int{7, 6, 4, 3, 1}), 0, "Default case 2 failed")
}

func TestEdgeCaseEmptyList(t *testing.T) {
	checkResult(t, maxProfit([]int{}), 0, "Edge case empty list failed")
}

func TestEdgeCaseSingleElement(t *testing.T) {
	checkResult(t, maxProfit([]int{10}), 0, "Edge case single element failed")
}

func TestEdgeCaseTwoElementsProfit(t *testing.T) {
	checkResult(t, maxProfit([]int{1, 10}), 9, "Edge case two elements profit failed")
}

func TestEdgeCaseTwoElementsLoss(t *testing.T) {
	checkResult(t, maxProfit([]int{10, 1}), 0, "Edge case two elements loss failed")
}

func TestConstantPrices(t *testing.T) {
	checkResult(t, maxProfit([]int{5, 5, 5, 5}), 0, "Constant prices case failed")
}

func TestEarlyLowLateHigh(t *testing.T) {
	checkResult(t, maxProfit([]int{1, 2, 90, 10, 5}), 89, "Early low late high case failed")
}

func TestLargeJumpAtEnd(t *testing.T) {
	checkResult(t, maxProfit([]int{5, 4, 3, 2, 100}), 98, "Large jump at end case failed")
}

func TestMultipleOpportunities(t *testing.T) {
	checkResult(t, maxProfit([]int{3, 2, 6, 1, 4}), 4, "Multiple opportunities case failed")
}

func TestPriceDipsBeforeRise(t *testing.T) {
	checkResult(t, maxProfit([]int{2, 1, 2, 1, 2}), 1, "Price dips before rise case failed")
}
