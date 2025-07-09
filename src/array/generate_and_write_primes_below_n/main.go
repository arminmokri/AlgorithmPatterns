package main

import (
	"fmt"
	"math"
	"os"
	"strings"
)

var debug bool = true

func MatrixToString(matrix [][]interface{}) string {
	if len(matrix) == 0 {
		return "[]"
	}
	if len(matrix) == 1 && len(matrix[0]) == 0 {
		return "[[]]"
	}

	maxWidth := 0
	for _, row := range matrix {
		for _, val := range row {
			strVal := fmt.Sprintf("%v", val)
			if len(strVal) > maxWidth {
				maxWidth = len(strVal)
			}
		}
	}

	var sb strings.Builder
	for _, row := range matrix {
		sb.WriteString("[ ")
		for i, val := range row {
			format := fmt.Sprintf("%%%dv", maxWidth)
			sb.WriteString(fmt.Sprintf(format, val))
			if i < len(row)-1 {
				sb.WriteString(", ")
			}
		}
		sb.WriteString(" ]\n")
	}
	return strings.TrimSpace(sb.String())
}

func ListToString(list []interface{}) string {
	if len(list) == 0 {
		return "[]"
	}

	parts := make([]string, len(list))
	for i, val := range list {
		parts[i] = fmt.Sprintf("(%d) %v", i, val)
	}
	return "[" + strings.Join(parts, ", ") + "]"
}

func isPrime(number int) bool {
	var flag int = 0
	for i := 2; i < int(math.Sqrt(float64(number)))+1; i++ {
		if number%i == 0 {
			flag = 1
			break
		}
	}

	return flag == 0
}

func generatePrimesBelowN(N int, filePath string) []int {
	if debug {
		fmt.Println()
	}

	var primeList = make([]int, 0, 5)

	for i := 2; i < N; i++ {
		if isPrime(i) {
			primeList = append(primeList, i)
		}
	}

	if debug {
		fmt.Printf("primeList=%v\n", primeList)
	}

	data := fmt.Sprintf("%v", primeList)
	os.WriteFile(filePath, []byte(data), 0644)

	return primeList
}
