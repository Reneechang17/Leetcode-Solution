package main
// Easy
// Time:O(n+m), Space:O(n)
// https://leetcode.cn/problems/next-greater-element-i/

func nextGreaterElement(nums1 []int, nums2 []int) []int {
    nextGreater := make(map[int]int)
    stack := []int{}

    // go through nums from right to left
    for i := len(nums2) - 1; i >= 0; i-- {
        num := nums2[i]

        // pop all elements <= cur 
        for len(stack) > 0 && stack[len(stack) - 1] <= num {
            stack = stack[:len(stack) - 1] // pop
        }

        if len(stack) > 0 {
            nextGreater[num] = stack[len(stack) - 1]
        } else {
            nextGreater[num] = -1
        }
        stack = append(stack, num)
    }

    res := make([]int, len(nums1))
    for i, num := range nums1 {
        res[i] = nextGreater[num]
    }
    return res
}
