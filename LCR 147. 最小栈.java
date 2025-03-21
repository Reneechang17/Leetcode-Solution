// Easy
// Stack
// Time:O(1),Space:O(n)
// https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/

import java.util.*;

class MinStack {
    // one stack store the current element in stack
    // another one store the min element for the cur stack

    private Deque<Integer> s1 = new ArrayDeque<>();
    private Deque<Integer> s2 = new ArrayDeque<>();

    /** initialize your data structure here. */
    public MinStack() {
        s2.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        s1.push(x);
        s2.push(Math.min(x, s2.peek()));
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
