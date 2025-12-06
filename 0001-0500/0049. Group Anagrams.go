package main
// Medium
// Time:O(nk), Space:O(nk)
// https://leetcode.cn/problems/group-anagrams/

func groupAnagrams(strs []string) [][]string {
    groups := make(map[[26]int][]string)

    for _, s := range strs {
        // use char's freq as key
        key := [26]int{}
        for _, c := range s {
            key[c - 'a']++
        }
        groups[key] = append(groups[key], s)
    }
    res := [][]string{}
    for _, g := range groups {
        res = append(res, g)
    }
    return res
}
