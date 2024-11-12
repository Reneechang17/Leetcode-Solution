// Medium
// Stack
// O(1)
// https://leetcode.cn/problems/min-stack/

import java.util.*;

class MinStack {
    // we need two Stack to complete it as O(1)
    // one stack is use to store the current element in stack
    // another one is to store the min element for the cur stack
    private Deque<Integer> s1 = new ArrayDeque<>();
    private Deque<Integer> s2 = new ArrayDeque<>(); 

    public MinStack() {
        // initialize the s2 with max element to avoid covered
        s2.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        s1.push(val);
        s2.push(Math.min(val, s2.peek()));
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
