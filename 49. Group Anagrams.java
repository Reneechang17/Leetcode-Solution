// Medium
// Hash Table, Array, String
// O(N * K)
// N: number of String
// K: the average length of String
// https://leetcode.com/problems/group-anagrams/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> codeToGroup = new HashMap<>();
        for (String s : strs) {
            String code = encode(s);
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(s);
        }

        List<List<String>> res = new LinkedList<>();
        for (List<String> group : codeToGroup.values()) {
            res.add(group);
        }
        return res;
    }

    String encode(String s) {
        char[] cnt = new char[26];
        for (char c : s.toCharArray()) {
            int pos = c - 'a';
            cnt[pos]++;
        }
        return new String(cnt);
    }
}

/**
 * 難點：對字符串進行編碼
 * 代碼思路：
 * 遍歷字符串數組strs
 * 1. 對每一個遍歷到的字符串s進行編碼（這裡使用輔助函數）
 * 2. 將編碼相同的字符串放在一起
 * 用res列表來獲取結果：遍歷codeToGroup中的值，將裡面的List<String>加入res中
 * 
 * 編碼思路（返回字符串）：
 * 1. 先開數組cnt，計數每一個字母出現的次數，大小26
 * 2. 增強for遍歷s（這裡用toCharArray對s操作一下）
 * （1）對於每一個字符c，計算他在cnt數組中的位置pos（用c-'a'）
 * （2）在該位置cnt[pos]++
 * 3. 最後將這個計數數組轉換成一個字符串，作為該字符串的編碼
 * Important: 因為兩個字謎的字符計數是相同的，所以他們會有相同的編碼
 **/
