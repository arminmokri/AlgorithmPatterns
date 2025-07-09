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
	checkResult(t, firstRepeatedWord("alpha beta gamma alpha delta beta"), "alpha", "Default case failed")
}

func TestNoRepeats(t *testing.T) {
	checkResult(t, firstRepeatedWord("apple banana cherry"), "", "No repeats case failed")
}

func TestRepeatsImmediately(t *testing.T) {
	checkResult(t, firstRepeatedWord("one one two three"), "one", "Repeats immediately case failed")
}

func TestCaseSensitive(t *testing.T) {
	checkResult(t, firstRepeatedWord("Dog dog DOG"), "dog", "Case sensitive case failed")
}

func TestTrailingAndLeadingSpaces(t *testing.T) {
	checkResult(t, firstRepeatedWord("  this  is   a test this is"), "this", "Trailing and leading spaces case failed")
}

func TestOnlyOneWord(t *testing.T) {
	checkResult(t, firstRepeatedWord("hello"), "", "Only one word case failed")
}

func TestEmptyString(t *testing.T) {
	checkResult(t, firstRepeatedWord(""), "", "Empty string case failed")
}

func TestAllRepeated(t *testing.T) {
	checkResult(t, firstRepeatedWord("x x x x x"), "x", "All repeated case failed")
}
