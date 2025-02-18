// Medium
// LinkedList
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/plus-one-linked-list/

class Solution {
  // [1,2,3] => 123+1=123 => [1,2,4]
  // Reverse -> calculate carry -> reverse again
  public ListNode plusOne(ListNode head) {
      head = reverse(head);
      ListNode cur = head;
      int carry = 1;
      while (cur != null) {
          int sum = cur.val + carry;
          cur.val = sum % 10;
          carry = sum / 10;
          if (carry == 0) break; // no carry
          if (cur.next == null && carry == 1) {
              cur.next = new ListNode(1);
              carry = 0;
          }
          cur = cur.next;
      }
      return reverse(head);
  }
  private ListNode reverse(ListNode head) {
      ListNode prev = null;
      while (head != null) {
          ListNode next = head.next;
          head.next = prev;
          prev = head;
          head = next;
      }
      return prev;
  }
}
