package main
// Easy
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/longest-harmonious-subsequence/

func findLHS(nums []int) int {
    count := make(map[int]int)

    for _, x := range nums {
        count[x]++
    }
    
    maxLen := 0

    // for each x, check if x+1 exists
    // if exists, count[x]+count[x+1] is a answer
    for x := range count {
        if val, ok := count[x + 1]; ok {
            maxLen = max(maxLen, count[x] + val)
        }
    }
    return maxLen
}
