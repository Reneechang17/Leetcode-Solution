// Medium
// Hash Table, Encoding
// O(N * K)
// https://leetcode.cn/problems/group-anagrams/

import java.util.*;

class Solution {
    // we need to find a way to encode the words
    // we can calculate the code with each char, and use Map to store them
    // the key will be the encoded code, the value will be the words
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String code = encode(s);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        // iterate the value in map
        for (List<String> v : map.values()) {
            res.add(v);
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
