// Medium
// Backtracking
// Time:O(4^n / sqrt(n) * n),Space:O(4^n / sqrt(n) * n)
// https://leetcode.cn/problems/generate-parentheses/

import java.util.*;

class Solution {
    // seems like we need to find all the possible->backtracking
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // use StringBuilder instead of String to avoid creating new string in each recursion
        backtracking(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtracking(List<String> res, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }
        // try to add open bracket
        if (open < n) {
            cur.append("(");
            backtracking(res, cur, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        // try to add close bracket
        // since open bracket must be added before close bracket
        if (close < open) {
            cur.append(")");
            backtracking(res, cur, open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
