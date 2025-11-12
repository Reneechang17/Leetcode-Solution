// Easy
// Map, String
// Time:O(n*m),Space:O(n)
// https://leetcode.cn/problems/count-pairs-of-similar-strings/

import java.util.*;

class Solution {
    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;

        for (String w : words) {
            Set<Character> set = new HashSet<>();
            for (char c : w.toCharArray()) {
                set.add(c);
            }

            String key = set.toString();

            if (map.containsKey(key)) {
                cnt += map.get(key);
            }

            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return cnt;
    }
}
