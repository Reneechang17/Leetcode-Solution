package main
// Medium
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/subarray-sum-equals-k/

func subarraySum(nums []int, k int) int {
    count := 0
    prefixSum := 0
    m := make(map[int] int)
    m[0] = 1

    for _, x := range nums {
        prefixSum += x

        if val, ok := m[prefixSum - k]; ok {
            count += val
        }
        m[prefixSum]++
    }
    return count
}
