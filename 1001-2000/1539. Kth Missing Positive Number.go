package main
// Easy
// https://leetcode.cn/problems/kth-missing-positive-number/

// Simulation -> Time:O(n+k), Space:O(1)
func findKthPositive(arr []int, k int) int {
    cur := 1
    i := 0

    for k > 0 {
        if i < len(arr) && arr[i] == cur {
            i++
        } else {
            k--
            if k == 0 {
                return cur
            }
        }
        cur++
    }
    return cur - 1
}

// Binary search -> Time:O(logn), Space:O(1)
func findKthPositive2(arr []int, k int) int {
    // the missing num in index 1 = nums[i] - (i + 1)
    left, right := 0, len(arr)
    
    for left < right {
        mid := (left + right) / 2
        missing := arr[mid] - (mid + 1)

        if missing < k {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left + k
}
