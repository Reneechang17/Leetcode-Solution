package main
// Medium
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/longest-repeating-character-replacement/

func characterReplacement(s string, k int) int {
    count := make(map[byte]int)
    maxFreq := 0
    maxLen := 0
    left := 0

    for right := 0; right < len(s); right++ {
        count[s[right]]++
        maxFreq = max(maxFreq, count[s[right]])

        windowLen := right - left + 1
        if windowLen - maxFreq > k {
            count[s[left]]--
            left++
        }
        maxLen = max(maxLen, right - left + 1)
    }
    return maxLen
}
