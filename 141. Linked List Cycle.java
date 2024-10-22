// Easy
// Two Pointers
// O(n)
// https://leetcode.cn/problems/linked-list-cycle/

class Solution {
  // Two pointers -> fast go 2 steps, slow go 1 steps
  // If there is a cycle, they will meet at some point
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
