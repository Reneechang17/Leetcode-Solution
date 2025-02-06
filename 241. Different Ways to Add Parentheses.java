// Medium
// Divide and Conquer
// Time:O(2^n),Space:O(2^n) call stack
// https://leetcode.cn/problems/different-ways-to-add-parentheses/

import java.util.*;
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 递归计算左右两部分的所有可能
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                // 计算所有可能组合
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
        // 如果表达式没有运算符，直接转换成整数返回
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}

// input是一个字符串，由数字和运算符组成。需要添加不同括号，使计算结果不同并找到所有可能的计算结果
// 不同括号位置会导致不同的计算方式，可以将其拆分成多个子问题：
//   - 找到所有运算符，把它们当作分割点，把整个表达式拆分成两部分
//   - 递归计算左右部分的所有可能值，然后合并结果 -> 分治
