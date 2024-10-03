// Medium
// Stack, Design
// O(1)
// https://leetcode.cn/problems/min-stack/

import java.util.*;

class MinStack {
  private Deque<Integer> s1 = new ArrayDeque<>();
  private Deque<Integer> s2 = new ArrayDeque<>();

  public MinStack() {
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

/**
 * 最小棧，要求在常數時間內查找最小元素
 * 支持push、pop、top、getMin操作
 * 
 * 可以用兩個棧來實現，一個棧存儲當前數據，一個棧存當前棧中的最小值，初始化s2為Integer.MAX_VALUE
 * 
 * push:將val壓入s1，並將val和s2的頂部元素中的最小值壓入s2
 * pop:將s1和s2的頂部元素彈出
 * top:返回s1的頂部元素
 * getMin:返回s2的頂部元素
 **/