// Medium
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/split-a-circular-linked-list/

class Solution {
  public ListNode[] splitCircularLinkedList(ListNode list) {
      if (list == null || list.next == null) return new ListNode[]{list, null};

      // find middle point
      ListNode slow = list, fast = list;
      while (fast.next != list && fast.next.next != list) {
          slow = slow.next;
          fast = fast.next.next;
      }

      ListNode list2 = slow.next;
      slow.next = list; // make first part in cycle

      ListNode cur = list2;
      while (cur.next != list) {
          cur = cur.next;
      }
      cur.next = list2;
      return new ListNode[]{list, list2};
  }
}
