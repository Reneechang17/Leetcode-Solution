// Easy
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/valid-parentheses/

import java.util.Stack;

class Solution {
    // Use stack to ensure the order
    //   - when we occur open bracket, push its corresponding close to stack
    //   - or check if the element is equal to the stack.pop()
    // Finally check if stack is empty, if so, means all chars has been matched
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
