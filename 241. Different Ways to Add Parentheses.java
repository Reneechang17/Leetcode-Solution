// Medium
// Divide and Conquer
// O(n * 2^n)
// https://leetcode.cn/problems/different-ways-to-add-parentheses/

import java.util.*;

class Solution {
    // 考慮用分治，遇到運算符時
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 遇到運算符分治，分成左右兩份
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // 對左右部分的每種結果，計算當前運算符的結果
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        // 如果沒有運算符直接把String轉成Integer
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
