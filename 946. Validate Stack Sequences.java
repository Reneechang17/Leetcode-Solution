// Medium
// Stack
// O(n)
// https://leetcode.cn/problems/validate-stack-sequences/

import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 這題其實就是檢查壓棧和出棧的順序是不是一致 -> 模擬
        // 遍歷pushed數組，將數組元素壓入棧中，然後檢查它的棧頂元素和popped數組要出棧的是否一致
        Stack<Integer> stack = new Stack<>();
        int i = 0; 
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}
