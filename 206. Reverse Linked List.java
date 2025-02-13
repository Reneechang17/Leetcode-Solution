// Easy
// LinkedList
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/reverse-linked-list/

class Solution {
  // switch the direction of the pointer
  public ListNode reverseList(ListNode head) {
      ListNode pre = null, cur = head;
      while (cur != null) {
          ListNode tmp = cur.next;
          cur.next = pre;
          pre = cur;
          cur = tmp;
      }
      return pre;
  }
}
