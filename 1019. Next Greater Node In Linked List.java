// Medium
// LinkedList, Stack
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/next-greater-node-in-linked-list/

import java.util.*;
class Solution {
  // Convert LinkedList to List first
  // Use monotonic decreasing stack to find next greater elements
  //   - if stack'top is smaller, update res[stack.pop()] as cur element
  public int[] nextLargerNodes(ListNode head) {
      List<Integer> list = new ArrayList<>();
      ListNode cur = head;
      while (cur != null) {
          list.add(cur.val);
          cur = cur.next;
      }
      int[] res = new int[list.size()];
      Stack<Integer> stack = new Stack<>();

      for (int i = 0; i < list.size(); i++) {
          while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
              res[stack.pop()] = list.get(i);
          }
          stack.push(i);
      }
      return res;
  }
}
