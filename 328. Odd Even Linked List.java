// Medium
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/odd-even-linked-list/

class Solution {
  // Two Pointers to separate odd/even index nodes
  // And iterate the list to link nodes, 
  //  at the end, connect the odd and even together
  public ListNode oddEvenList(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode odd = head, even = head.next, evenHead = even;

      while (even != null && even.next != null) {
          odd.next = even.next;
          odd = odd.next;
          even.next = odd.next;
          even = even.next;
      }
      odd.next = evenHead; // connect two LinkedList
      return head;
  }
}
