// Medium
// Hash Table
// Time:O(nk), Space:O(nk)
// n is the length of strs, k is the average length of the strings
// https://leetcode.cn/problems/group-anagrams/

import java.util.*;

class Solution {
    // Group anagrams by encoding each word into a frequency count of letters.
    // 1. Encode each word into a key (letter frequency) using a 26-char array.
    // 2. Use Map to group words sharing the same encoded key.
    // 3. Return all groups as a list of lists.
    public List<List<String>> groupAnagrams(String[] strs) {
        // map store the encode String and all the string has same code
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String code = encode(s);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
    private String encode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return new String(count);
    }
}
