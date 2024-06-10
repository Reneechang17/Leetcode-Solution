// Easy
// LinkedList, Two Pointers
// O(n)

class Solution {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(-1);
      dummy.next = head;

      ListNode fast = dummy, slow = dummy;
      for(int i = 0; i <= n; i++){
          fast = fast.next;
      }

      while(fast != null){
          fast = fast.next;
          slow = slow.next;
      }

      slow.next = slow.next.next;
      return dummy.next;
  }
}