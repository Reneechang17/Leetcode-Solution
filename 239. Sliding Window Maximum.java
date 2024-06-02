import java.util.Deque;
import java.util.LinkedList;

// Hard 
// Deque
// O(n)

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