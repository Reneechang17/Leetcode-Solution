// Easy
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/valid-parentheses/

import java.util.Stack;

class Solution {
    // stack-> when we occur ({[, push the )}] to stack
    // or check if the cur element is equal to the stack.pop()
    // finally check if stack is empty, if so, means all the c has been matched
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
