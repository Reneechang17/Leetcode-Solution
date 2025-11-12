// Easy
// Array
// Time:O(mn),Space:O(n)
// https://leetcode.cn/problems/find-resultant-array-after-removing-anagrams/

import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int n = words.length;
        for (int i = 1; i < n; i++) {
            if (!compare(words[i], words[i - 1])) {
                res.add(words[i]);
            }
        }
        return res;
    }

    private boolean compare(String w1, String w2) {
        int[] freq = new int[26];
        for (char c : w1.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : w2.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int x : freq) {
            if (x != 0) return false;
        }
        return true;
    }
}
