package main

import (
	"fmt"
	"os"
	"strings"
	"testing"
)

func checkResult[T comparable](t *testing.T, got T, want T, message string, args ...any) {
	t.Helper()
	if got != want {
		t.Errorf("%s: got = %v, want = %v", fmt.Sprintf(message, args...), got, want)
	}
}

func slicesEqual(a, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}

func TestDefaultCase(t *testing.T) {
	tmpFile, err := os.CreateTemp("", "*.txt")
	if err != nil {
		t.Fatalf("Failed to create temp file: %v", err)
	}
	defer os.Remove(tmpFile.Name())

	expected := []int{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97}
	result := generatePrimesBelowN(100, tmpFile.Name())

	if !slicesEqual(result, expected) {
		t.Errorf("Default case failed: got = %v, want = %v", result, expected)
	}

	content, err := os.ReadFile(tmpFile.Name())
	if err != nil {
		t.Fatalf("Failed to read file: %v", err)
	}
	fileContent := string(content)
	if !strings.Contains(fileContent, "2") || !strings.Contains(fileContent, "7") || !strings.HasPrefix(fileContent, "[") {
		t.Errorf("File content checks failed. Content: %s", fileContent)
	}
}

func TestPrimesBelow10(t *testing.T) {
	tmpFile, err := os.CreateTemp("", "*.txt")
	if err != nil {
		t.Fatalf("Failed to create temp file: %v", err)
	}
	defer os.Remove(tmpFile.Name())

	expected := []int{2, 3, 5, 7}
	result := generatePrimesBelowN(10, tmpFile.Name())

	if !slicesEqual(result, expected) {
		t.Errorf("Primes below 10 case failed: got = %v, want = %v", result, expected)
	}

	content, err := os.ReadFile(tmpFile.Name())
	if err != nil {
		t.Fatalf("Failed to read file: %v", err)
	}
	fileContent := string(content)
	if !strings.Contains(fileContent, "2") || !strings.Contains(fileContent, "7") || !strings.HasPrefix(fileContent, "[") {
		t.Errorf("File content checks failed. Content: %s", fileContent)
	}
}

func TestPrimesBelow2(t *testing.T) {
	tmpFile, err := os.CreateTemp("", "*.txt")
	if err != nil {
		t.Fatalf("Failed to create temp file: %v", err)
	}
	defer os.Remove(tmpFile.Name())

	expected := []int{}
	result := generatePrimesBelowN(2, tmpFile.Name())

	if !slicesEqual(result, expected) {
		t.Errorf("Primes below 2 case failed: got = %v, want = %v", result, expected)
	}

	content, err := os.ReadFile(tmpFile.Name())
	if err != nil {
		t.Fatalf("Failed to read file: %v", err)
	}
	fileContent := strings.TrimSpace(string(content))
	if fileContent != "[]" {
		t.Errorf("Expected '[]', got: %s", fileContent)
	}
}

func TestFileWritten(t *testing.T) {
	tmpFile, err := os.CreateTemp("", "*.txt")
	if err != nil {
		t.Fatalf("Failed to create temp file: %v", err)
	}
	defer os.Remove(tmpFile.Name())

	generatePrimesBelowN(20, tmpFile.Name())

	content, err := os.ReadFile(tmpFile.Name())
	if err != nil {
		t.Fatalf("Failed to read file: %v", err)
	}
	fileContent := string(content)
	if !strings.Contains(fileContent, "13") || !strings.Contains(fileContent, "19") {
		t.Errorf("File content missing expected primes. Content: %s", fileContent)
	}
}
