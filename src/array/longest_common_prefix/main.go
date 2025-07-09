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

func longestCommonPrefix(strs []string) string {
	if debug {
		fmt.Println()
	}
	var biggestPrefix string = ""
	var minStr string = ""
	if len(strs) > 0 {
		minStr = strs[0]
	}

	for _, str := range strs {
		if len(str) < len(minStr) {
			minStr = str
		}
	}

	for i := len(minStr); i > 0; i-- {
		prefixStr := minStr[0:i]

		if debug {
			fmt.Println("prefixStr=" + prefixStr)
		}

		var flag int = 0
		for _, currentStr := range strs {
			if minStr == currentStr {
				continue
			}
			if !strings.HasPrefix(currentStr, prefixStr) {
				flag = 1
				break
			}
		}

		if flag == 0 {
			biggestPrefix = prefixStr
			break
		}
	}

	return biggestPrefix
}
