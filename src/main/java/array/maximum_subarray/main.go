package main

import (
	"fmt"
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

func maxSubArray(nums []int) int {
	if debug {
		fmt.Println()
	}

	var max int = nums[0]
	var sum int = 0

	for _, num := range nums {
		if sum < 0 {
			sum = 0
		}

		sum = sum + num

		if max < sum {
			max = sum
		}
	}

	if debug {
		fmt.Printf("max=%d nums=%v", max, nums)
	}

	return max
}
