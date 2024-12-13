// Hard
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/basic-calculator/

import java.util.*;

class Solution {
    // Use stack to handle nested parentheses and preserve intermediate results and signs
    // Keep track of the current sign to correctly apply addition or subtraction
    // Handle multi-digit numbers by accumulating digits into number
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, number = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * number;
                number = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if (number != 0) {
            res += sign * number;
        }
        return res;
    }
}
