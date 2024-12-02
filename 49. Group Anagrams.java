// Medium
// Hash Table
// Time:O(nk), Space:O(nk)
// n is the length of strs, k is the average length of the strings
// https://leetcode.cn/problems/group-anagrams/

import java.util.*;

class Solution {
    // Find a way to encode the words
    // we can calculate the code with each char, and use Map to store them
    // the key will be the encoded code, the value will be the words
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
