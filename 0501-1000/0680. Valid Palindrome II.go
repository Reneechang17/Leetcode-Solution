package main
// Easy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/valid-palindrome-ii/

func validPalindrome(s string) bool {
    left, right := 0, len(s) - 1
    
    for left < right {
        if s[left] != s[right] {
            // del left or right
            return isValid(s, left + 1, right) || isValid(s, left, right - 1)
        }
        left++
        right--
    }
    return true
}

func isValid(s string, left, right int) bool {
    for left < right {
        if s[left] != s[right] {
            return false
        }
        left++
        right--
    }
    return true
}