// Easy
// String, Array, Hashset
// https://leetcode.cn/problems/maximum-number-of-words-you-can-type/

import java.util.*;

class Solution {
    // Time: O(n), Space: O(1)
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] arr = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            arr[c - 'a'] = true;
        }

        String[] words = text.split(" ");
        int cnt = 0;

        for (String w : words) {
            boolean flag = true;
            for (char c : w.toCharArray()) {
                if (arr[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                cnt++;
        }
        return cnt;
    }
}

class Solution2 {
    // Time: O(n), Space: O(n)
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }

        String[] words = text.split(" ");
        int cnt = 0;
        for (String w : words) {
            boolean flag = true;
            for (char c : w.toCharArray()) {
                if (set.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}
