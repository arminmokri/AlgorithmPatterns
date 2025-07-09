package main

import (
	"fmt"
	"testing"
)

func checkResult[T comparable](t *testing.T, got T, want T, message string, args ...any) {
	t.Helper() // Marks this function as a helper in error reports
	if got != want {
		t.Errorf("%s: got = %v, want = %v", fmt.Sprintf(message, args...), got, want)
	}
}

func TestDefaultCases(t *testing.T) {
	checkResult(t, arbitraryArguments("str1", "str2", "str3"), "str1.str2.str3", "Default case 1 failed")
	checkResult(t, arbitraryArguments("str1", "str2", "str3", "str4", "str5"), "str1.str2.str3.str4.str5", "Default case 2 failed")
}

func TestSingleArgument(t *testing.T) {
	checkResult(t, arbitraryArguments("only"), "only", "Single argument case failed")
}

func TestNoArgument(t *testing.T) {
	checkResult(t, arbitraryArguments(), "", "No argument case failed")
}

func TestWithEmptyStrings(t *testing.T) {
	checkResult(t, arbitraryArguments("", "a", ""), ".a.", "Empty strings case failed")
}

func TestWithSpecialCharacters(t *testing.T) {
	checkResult(t, arbitraryArguments("a!", "@b#", "$c%"), "a!.@b#.$c%", "Special characters case failed")
}
