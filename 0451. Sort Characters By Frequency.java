// Medium
// Hash Table, Sorting
// Time:O(n logn),Space:O(n)
// https://leetcode.cn/problems/sort-characters-by-frequency/

import java.util.*;
class Solution {
    // Use HashMap to count the chars freq and sort by it
    // Construct the final string 
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sorted = new ArrayList<>(map.entrySet());
        sorted.sort((a, b) -> b.getValue() - a.getValue());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sorted) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
