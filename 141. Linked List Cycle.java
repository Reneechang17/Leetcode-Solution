// Easy
// Two Pointers, LinkedList
// O(n)
// https://leetcode.com/problems/linked-list-cycle/

class Solution {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}

/**
 * 環形鏈表：快慢指針
 * 定義快慢指針從head走，快指針每次走2，慢指針每次走1
 * 如果相遇就是有環
 **/