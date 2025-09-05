// Easy
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/valid-parentheses/

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')'); // which means we expect later we see its partner
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || c != stack.pop())
                    return false;
            }
        }
        return stack.isEmpty(); // if all matched, expected nothing in stack
    }
}
