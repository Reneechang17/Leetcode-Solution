package main
// Medium
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/count-the-number-of-computer-unlocking-permutations/

func countPermutations(complexity []int) int {
    n := len(complexity)

    for i := 1; i < n; i++ {
        if complexity[i] <= complexity[0] {
            return 0
        }
    }

    // calculate (n-1)!
    ans := 1
    MOD := 1000000007
    for i := 2; i < n; i++ {
        ans = ans * i % MOD
    }
    return ans
}
