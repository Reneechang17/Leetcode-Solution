// Hard
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/longest-valid-parentheses/

import java.util.Stack;
class Solution {
    // Use stack to store index of unmatched parentheses
    // Push -1 initially to handle edge cases like "()" or single ')'
    // For '(' -> push its index to the stack
    // For ')' -> pop an index to match a '(':
    //   - If stack is empty, push cur index as the base for next calculation
    //   - Otherwise, calculate valid parentheses len: cur index - stack.peek()
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); // store left bracket index
            } else {
                stack.pop(); // try to match a '('
                if (stack.isEmpty()) {
                    stack.push(i); // push unmatch ')' as new base
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
