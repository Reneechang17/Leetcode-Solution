// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/middle-of-the-linked-list/

class Solution {
  public ListNode middleNode(ListNode head) {
      ListNode fast = head, slow = head;
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
      }
      return slow;
  }
}
