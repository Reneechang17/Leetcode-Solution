package main
// Medium
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/remove-k-digits/

import "strings"
func removeKdigits(num string, k int) string {
    stack := []byte{}

    for i := 0; i < len(num); i++ {
        for len(stack) > 0 && k > 0 && stack[len(stack) - 1] > num[i] {
            stack = stack[:len(stack) - 1]
            k--
        }
        stack = append(stack, num[i])
    }

    stack = stack[:len(stack) - k]
    // remove prefix-0
    res := strings.TrimLeft(string(stack), "0")

    if res == "" {
        return "0"
    }
    return res
}
