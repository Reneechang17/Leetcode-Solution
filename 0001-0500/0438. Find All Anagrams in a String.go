package main
// Medium
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/find-all-anagrams-in-a-string/

func findAnagrams(s string, p string) []int {
    res := []int{}
    if len(s) < len(p) {
        return res
    }

    // count p's freq
    pCount := make(map[byte]int)
    for i := 0; i < len(p); i++ {
        pCount[p[i]]++
    }

    windowCount := make(map[byte]int)
    for i := 0; i < len(s); i++ {
        windowCount[s[i]]++

        if i >= len(p) {
            left := s[i - len(p)]
            windowCount[left]--
            if windowCount[left] == 0 {
                delete(windowCount, left)
            }
        }
        
        if i >= len(p) - 1 && checkEqual(pCount, windowCount) {
            res = append(res, i - len(p) + 1)
        }
    }
    return res
}

func checkEqual(m1, m2 map[byte]int) bool {
    if len(m1) != len(m2) {
        return false
    }
    for k, v := range m1 {
        if m2[k] != v {
            return false
        }
    }
    return true
}
