// Medium
// Stack, Design
// O(1)
// https://leetcode.cn/problems/min-stack/

import java.util.*;

class MinStack {
    // 最小棧，需要完成正常棧操作：push, pop, top
    // O(1)返回棧中最小的元素 -> 需要借助額外的棧完成

    // s1處理當前棧中的數據
    private Deque<Integer> s1 = new ArrayDeque<>();
    // s2存儲當前棧中的最小值
    private Deque<Integer> s2 = new ArrayDeque<>();

    public MinStack() {
        // 初始化s2時，先放置最大值避免空棧
        s2.push(Integer.MAX_VALUE);
    }
    
    // 將元素入棧
    public void push(int val) {
        s1.push(val);
        // 比較當前元素和s2棧頂元素，將小的壓入s2
        s2.push(Math.min(val, s2.peek()));
    }
    
    // 元素出棧
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    // 返回棧頂元素
    public int top() {
        return s1.peek();
    }
    
    // 獲取最小值
    public int getMin() {
        return s2.peek();
    }
}
