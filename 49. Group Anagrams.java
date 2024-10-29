// Medium
// Hash Table, String
// O(N * K)
// https://leetcode.cn/problems/group-anagrams/

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 對字母編碼，一樣字母組成的string其編碼是一樣的
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String code = encode(s);
            // 將相同編碼的字符串放在一起
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> groups : map.values()) {
            res.add(groups);
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

/**
 * 字母異位詞分組：給定一個字符串數組，將字母異位詞組合在一起
 * 
 * 思路：對字符串進行編碼，字母相同的字符串編碼是一樣的
 * 遍歷字符串數組strs
 * 1. 對每一個遍歷到的字符串s進行編碼（這裡使用輔助函數）
 * 2. 將編碼相同的字符串放在一起
 * 用res列表來獲取結果：遍歷map中的值，將裡面的List<String>加入res中
 * 
 * 編碼思路（返回字符串）：
 * 1. 先開數組cnt，計數每一個字母出現的次數，大小26
 * 2. 增強for遍歷s（這裡用toCharArray對s操作一下）
 * 3. 最後將這個計數數組轉換成一個字符串，作為該字符串的編碼
 **/
