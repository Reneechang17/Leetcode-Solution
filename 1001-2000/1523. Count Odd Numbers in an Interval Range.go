package main
// Easy
// Time:O(1), Space:O(1)
// https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/

func countOdds(low int, high int) int {
    len := high - low + 1

    if low % 2 == 0 {
        return len / 2
    }
    return (len + 1) / 2
}
