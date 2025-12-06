package main
// Easy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/first-unique-character-in-a-string/

func firstUniqChar(s string) int {
    count := [26]int{}

    for _, c := range s {
        count[c - 'a']++
    }

    for i, c := range s {
        if count[c - 'a'] == 1 {
            return i
        }
    }
    return -1
}
