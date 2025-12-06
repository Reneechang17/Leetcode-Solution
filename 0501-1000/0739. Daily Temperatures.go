package main
// Medium
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/daily-temperatures/

func dailyTemperatures(temperatures []int) []int {
    n := len(temperatures)
    res := make([]int, n)
    stack := []int{} // store index in stack

    for i := 0; i < n; i++ {
        for len(stack) > 0 && temperatures[i] > temperatures[stack[len(stack) - 1]] {
            prevIdx := stack[len(stack) - 1]
            stack = stack[:len(stack) - 1] // pop
            res[prevIdx] = i - prevIdx
        }
        stack = append(stack, i)
    }
    return res
}
