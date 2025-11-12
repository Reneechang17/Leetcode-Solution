// Medium
// Map, String, Sorting
// Time:O(n logn),Space:O(n)
// https://leetcode.cn/problems/sort-characters-by-frequency/

import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int w = map.get(c);
            for (int i = 0; i < w; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
