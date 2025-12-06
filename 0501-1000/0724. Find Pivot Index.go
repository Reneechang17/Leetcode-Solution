package main
// Easy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/find-pivot-index/

func pivotIndex(nums []int) int {
    sum := 0
    for _, x := range nums {
        sum += x
    }

    leftSum := 0
    for i, x := range nums {
        if leftSum == sum - leftSum - x {
            return i
        }
        leftSum += x
    }
    return -1
}
