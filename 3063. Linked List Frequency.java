// Easy
// LinkedList
// Time:O(n + k),Space:O(k)
// https://leetcode.cn/problems/linked-list-frequency/

import java.util.*;
class Solution {
  public ListNode frequenciesOfElements(ListNode head) {
      // Use Map to calculate the freq
      Map<Integer, Integer> map = new HashMap<>();
      ListNode cur = head;
      while (cur != null) {
          map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
          cur = cur.next;
      }

      // build the new LinkedList, the node value is the freq
      ListNode dummy = new ListNode(0);
      ListNode tail = dummy;
      for (int fre : map.values()) {
          tail.next = new ListNode(fre);
          tail = tail.next;
      }
      return dummy.next;
  }
}
