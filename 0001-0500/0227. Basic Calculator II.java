// Medium
// Stack
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/basic-calculator-ii/

import java.util.Stack;

class Solution {
    // Iterate the string and keep tracking the cur number and operator
    // Use stack to manage res:
    //  for '+', '-', push the number to stack
    //  for '*', '/', pop the last number, perform the operator and push the res
    // After loop, sum all the value in stack 
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            // 如果是最后一个字符，即使它是数字，也需要处理当前的 num，因为遍历马上结束
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(num * stack.pop());
                        break;
                    default:
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}

