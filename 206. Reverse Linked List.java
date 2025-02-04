// Easy
// LinkedList
// O(n)
// https://leetcode.cn/problems/reverse-linked-list/

class Solution {
  // switch the direction of the pointer
  // pre -> cur -> next
  // make the cur.next = pre; but we also need to store the cur.next first
  public ListNode reverseList(ListNode head) {
      ListNode pre = null;
      ListNode cur = head;
      ListNode temp; 

      while (cur != null) {
          temp = cur.next;
          cur.next = pre;
          pre = cur;
          cur = temp;
      }
      return pre;
  }
}
