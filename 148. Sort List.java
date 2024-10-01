// Medium
// Sorting
// O(n logn)
// https://leetcode.cn/problems/sort-list/

class Solution {
  public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) {
          return head;
      }

      // 快慢指針找鏈表中點
      ListNode mid = getMid(head);
      ListNode rightHead = mid.next;
      mid.next = null; // 斷開鏈表，分成前後兩段

      // 歸併排序左右兩部分
      ListNode left = sortList(head);
      ListNode right = sortList(rightHead);

      // 合併兩個排序好的鏈表
      return merge(left, right);
  }

  private ListNode getMid(ListNode head) {
      ListNode slow = head, fast = head.next;
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }
      return slow;
  }

  private ListNode merge(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode tail = dummy;

      while(l1 != null && l2 != null) {
          if (l1.val < l2.val) {
              tail.next = l1;
              l1 = l1.next;
          } else {
              tail.next = l2;
              l2 = l2.next;
          }
          tail = tail.next;
      }

      if (l1 != null) {
          tail.next = l1;
      } else {
          tail.next = l2;
      }

      return dummy.next;
  }
}
