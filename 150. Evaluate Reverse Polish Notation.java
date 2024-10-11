// Medium
// Stack
// O(N)
// https://leetcode.cn/problems/evaluate-reverse-polish-notation/

import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        // 用棧操作：遇到數字入棧，遇到符號就出棧頂的兩個做操作，然後再將結果壓入棧
        // 可以用Stack或是Deque做，Deque可作為棧也可以作為隊列，適合頻繁操作出入棧的操作
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
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
