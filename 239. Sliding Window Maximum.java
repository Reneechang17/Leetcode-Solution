// Hard 
// Deque
// O(n)
// https://leetcode.com/problems/sliding-window-maximum/

import java.util.Deque;
import java.util.LinkedList;

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
      if(nums == null || nums.length == 0 || k <= 0){
          return new int[0];
      }
      Deque<Integer> deque = new LinkedList<>();
      int[] res = new int[nums.length - k + 1]; // 窗口的最大邊界
      int index = 0;

      for(int i = 0; i < nums.length; i++){
          // 移除不在窗口內的元素索引
          // 如果隊列不為空，並且隊首元素的索引已經超出當前窗口的範圍，就從隊首移除
          while(!deque.isEmpty() && deque.peek() < i - k + 1){
              deque.poll();
          }
          // 如果隊列不為空，並且當前元素大於隊尾元素，就從隊列尾部移除
          while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
              deque.pollLast();
          }
          // 將當前元素索引加入隊列尾部
          deque.offer(i);
          // 當窗口長度達到k的時候，隊首元素即為當前窗口的最大值，加入結果列表
          if(i >= k - 1){
              res[index++] = nums[deque.peek()];
          }
      }
      return res;
  }
}

/**
 * 可以看一下example比較具體
 * 
 * 本題是找滑動窗口中的最大值，由於要不斷調整左右的值（也就是一直會有值從左邊出去、右邊加入），所以用雙端隊列。
 * 雙端隊列能夠從兩端進行插入和刪除插入。此題中，隊列存儲的是數組元素的索引，而索引對應的數組元素是從大到小排序的
 * 隊列的最左邊（即隊首）為最大值。
 **/