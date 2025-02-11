// Medium
// Prefix Sum + HashMap
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

import java.util.*;
class Solution {
  public ListNode removeZeroSumSublists(ListNode head) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      Map<Integer, ListNode> map = new HashMap<>();

      int prefixSum = 0;
      ListNode cur = dummy;
      
      // calculate the prefix sum, and store the last appear pos
      while (cur != null) {
          prefixSum += cur.val;
          map.put(prefixSum, cur);
          cur = cur.next;
      }

      // if the prefix sum repeats, remove nodes in between
      prefixSum = 0;
      cur = dummy;
      while (cur != null) {
          prefixSum += cur.val;
          cur.next = map.get(prefixSum).next; // skip the between part
          cur = cur.next;
      }
      return dummy.next;
  }
}
