// Medium
// Backtracking, String
// Time:O(4^n / sqrt(n) * n),Space:O(4^n / sqrt(n) * n)
// https://leetcode.cn/problems/Gu0c2T/

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    private void backtracking(List<String> res, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }
        // add open bracket
        if (open < n) {
            cur.append("(");
            backtracking(res, cur, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        // add close bracket
        if (close < open) {
            cur.append(")");
            backtracking(res, cur, open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
