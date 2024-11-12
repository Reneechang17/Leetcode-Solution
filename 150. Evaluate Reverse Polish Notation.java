// Medium
// Stack
// O(N)
// https://leetcode.cn/problems/evaluate-reverse-polish-notation/

import java.util.*;

class Solution {
    // we can operate by stack, when we occur number, then push to stack
    // and occur symbool, we pop two peek element and calculate it
    // finally push the res to stack
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            // which can ensure that no matter the number is negative or positive
            // or the number is more than one digit, can be parsed
            if (t.length() > 1 || Character.isDigit(t.charAt(0))) {
                stack.push(Integer.parseInt(t));
            } else {
                int y = stack.pop();
                int x = stack.pop();
                switch(t) {
                    case "+":
                        stack.push(x + y);
                        break;
                    case "-":
                        stack.push(x - y);
                        break;
                    case "*":
                        stack.push(x * y);
                        break;
                    case "/":
                        stack.push(x / y);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
