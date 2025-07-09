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
	checkResult(t, firstUniqueCharacter("stress"), 1, "Default case failed")
}

func TestNoUniqueCharacter(t *testing.T) {
	result := firstUniqueCharacter("aabbcc")
	if result != -1 {
		t.Errorf("No unique character case failed: got = %v, want = -1", result)
	}
}

func TestFirstCharacterUnique(t *testing.T) {
	checkResult(t, firstUniqueCharacter("abcdef"), 0, "First character unique case failed")
}

func TestLastCharacterUnique(t *testing.T) {
	checkResult(t, firstUniqueCharacter("aabbccd"), 6, "Last character unique case failed")
}

func TestEmptyString(t *testing.T) {
	result := firstUniqueCharacter("")
	if result != -1 {
		t.Errorf("Empty string case failed: got = %v, want = -1", result)
	}
}

func TestAllUniqueCharacters(t *testing.T) {
	checkResult(t, firstUniqueCharacter("abcde"), 0, "All unique characters case failed")
}

func TestSingleCharacter(t *testing.T) {
	checkResult(t, firstUniqueCharacter("z"), 0, "Single character case failed")
}

func TestMixedCase(t *testing.T) {
	checkResult(t, firstUniqueCharacter("AaBbCcD"), 0, "Mixed case failed")
}
