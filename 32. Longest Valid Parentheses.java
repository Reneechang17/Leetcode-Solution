// Hard
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/longest-valid-parentheses/

import java.util.Stack;

class Solution {
    // Use stack to store index of unmatched parentheses.
    // Push -1 initially to handle edge cases like "()" or single ')'.
    // For '(' -> push its index to the stack.
    //  - For ')' -> pop an index to match a '(':
    //    - If stack is empty, push cur index as the base for next calculation.
    //    - Otherwise, calculate valid parentheses length: cur index - stack.peek().
    // Keep track of the maximum valid length.   
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); 
            } else {
                stack.pop(); // try to match a '('
                if (stack.isEmpty()) {
                    // if stk is empty, push the index of ')'
                    stack.push(i); 
                } else {
                    // calculate the length
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
