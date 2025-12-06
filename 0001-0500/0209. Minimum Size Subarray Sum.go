package main
// Medium
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/minimum-size-subarray-sum/

func minSubArrayLen(target int, nums []int) int {
    n := len(nums)
    minLen := n + 1
    sum := 0
    left := 0

    for right := 0; right < n; right++ {
        sum += nums[right]
        for sum >= target {
            minLen = min(minLen, right - left + 1)
            sum -= nums[left]
            left++
        }
    }
    if minLen == n + 1 {
        return 0
    }
    return minLen
}
