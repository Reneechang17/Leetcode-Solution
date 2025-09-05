// Medium
// Backtracking, String
// Time:O(4^n / sqrt(n) * n),Space:O(4^n / sqrt(n) * n)
// https://leetcode.cn/problems/generate-parentheses/

// Since we need to find all the ways? -> Backtracking
// One point is the final string would be 2*n

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // we can use StringBuilder instead of String to avoid create new string in each recursion
        // res, StringBuilder, open bracket, close bracket, n
        backtracking(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtracking(List<String> res, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }

        // add open bracket(it should be add before close)
        if (open < n) {
            cur.append("(");
            backtracking(res, cur, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(")");
            backtracking(res, cur, open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
