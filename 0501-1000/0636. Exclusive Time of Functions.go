package main

// Medium
// String
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/exclusive-time-of-functions/

import (
	"fmt"
	"strconv"
	"strings"
)
func exclusiveTime(n int, logs []string) []int {
    res := make([]int, n)
    stack := []int{}
    prevTime := 0

    for _, log := range logs {
        parts := strings.Split(log, ":")
        funcId, _ := strconv.Atoi(parts[0])
        action := parts[1]
        timestamp, _ := strconv.Atoi(parts[2])

        if action == "start" {
            if len(stack) > 0 {
                res[stack[len(stack) - 1]] += timestamp - prevTime
            }
            stack = append(stack, funcId)
            prevTime = timestamp
        } else {
            // action == "end"
            res[stack[len(stack) - 1]] += timestamp - prevTime + 1
            stack = stack[:len(stack) - 1]
            prevTime = timestamp + 1
        }
    }
    return res
}

func main() {
	n := 2
	logs := []string{"0:start:0","1:start:2","1:end:5","0:end:6"}
	res := exclusiveTime(n, logs)
	fmt.Println(res)

	n = 1
    logs = []string{"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"}
    res = exclusiveTime(n, logs)
    fmt.Println(res)
}
