// Hard
// Stack, Iteration
// https://leetcode.cn/problems/longest-valid-parentheses/

import java.util.Stack;

class Solution {
    // two-way scanning
    // Time:O(n), Space:O(1)
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLen = 0;

        // left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLen;
    }
}

class Solution2 {
    // Actually Stack approach also decent but I don't think I can quickly come up in interview:D
    // Like thinking what we store in Stack......
    // Time:O(n), Space:O(n)
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // push -1 to handle edge cases like "()" or single ')'
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); // store left bracket index
            } else {
                stack.pop(); // try to pop and match a '('
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
