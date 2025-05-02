// Medium
// Backtracking
// Time:O(n*2^m),Space:O(n)
// https://leetcode.cn/problems/letter-case-permutation/

import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtracking(s.toCharArray(), 0, res, new StringBuilder());
        return res;
    }

    private void backtracking(char[] chars, int index, List<String> res, StringBuilder cur) {
        if (index == chars.length) {
            res.add(cur.toString());
            return;
        }

        char c = chars[index];
        // for each char, it can be lowercase or uppercase
        if (Character.isLetter(c)) {
            // op1: lowercase
            cur.append(Character.toLowerCase(c));
            backtracking(chars, index + 1, res, cur);
            cur.deleteCharAt(cur.length() - 1);

            // op2: uppercase
            cur.append(Character.toUpperCase(c));
            backtracking(chars, index + 1, res, cur);
            cur.deleteCharAt(cur.length() - 1);
            
        } else {
            // if digit, add directly
            cur.append(c);
            backtracking(chars, index + 1, res, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
