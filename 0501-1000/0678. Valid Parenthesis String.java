// Medium
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/valid-parenthesis-string/

import java.util.Stack;
class Solution {
    // Use two stacks: one for '(' indexs, one for '*' indexs
    //   - Push '(' and '*' index to corresponding stack
    //   - For ')', prioritize match '('. If not, match '*' 
    // Finally, match remaining '(' with '*' and ensure '*' after '('
    // If any '(' remains unmatched -> false; otherwise -> true
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        // match remaining '(' with '*'
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) return false;
        }
        return left.isEmpty();
    }
}
