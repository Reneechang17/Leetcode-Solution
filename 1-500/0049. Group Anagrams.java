// Medium
// Counting, HashMap
// Time:O(nk), Space:O(nk)
// https://leetcode.cn/problems/group-anagrams/

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // map -> key: encode code, value: corresponding strs
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String code = encoded(s);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> v : map.values()) {
            res.add(v);
        }
        return res;
    }

    private String encoded(String s) {
        char[] cnt = new char[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        return new String(cnt);
    }
}
