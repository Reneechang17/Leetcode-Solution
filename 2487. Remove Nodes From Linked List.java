// Medium
// LinkedList
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/remove-nodes-from-linked-list/

class Solution {
  // Reverse the linkedlist, then remove nodes where 
  //  - list[i]>list[i+1], remove list[i]
  // ex.[5,2,13,3,8] -> [8,3,13,2,5]
  //  - finally reverse back
  public ListNode removeNodes(ListNode head) {
      head = reverse(head);
      ListNode cur = head;
      int maxVal = cur.val;

      while (cur.next != null) {
          if (maxVal > cur.next.val) {
              cur.next = cur.next.next; // remove
          } else {
              maxVal = cur.next.val; // update maxVal
              cur = cur.next;
          }
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
