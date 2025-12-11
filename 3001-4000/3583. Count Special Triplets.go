package main
// Medium
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/count-special-triplets/

func specialTriplets(nums []int) int {
    const MOD = 1e9 + 7
    n := len(nums)
    res := 0

    rightCount := make(map[int]int)
    for i := 2; i < n; i++ {
        rightCount[nums[i]]++
    }

    leftCount := make(map[int]int)

    for j := 1; j < n - 1; j++ {
        leftCount[nums[j - 1]]++
        target := nums[j] * 2
        res = (res + leftCount[target] * rightCount[target]) % MOD
        rightCount[nums[j + 1]]--
    }
    return res
}
