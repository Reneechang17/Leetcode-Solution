// Medium
// LinkedList, Two Pointers
// O(n)

class Solution {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode deleteMiddle(ListNode head) {
    ListNode dummy = new ListNode(-1, head);
    ListNode fast = head, slow = dummy;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }
}