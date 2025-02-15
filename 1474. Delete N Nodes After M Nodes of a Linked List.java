// Easy
// LinkedList
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/

class Solution {
  // Use a pointer to traverse the list, everytime skip m-1 nodes
  // then delete n nodes, continue until reaching end
  public ListNode deleteNodes(ListNode head, int m, int n) {
      ListNode cur = head;
      while (cur != null) {
          // skip m-1 nodes, cur will stop at m
          for (int i = 1; i < m && cur != null; i++) {
              cur = cur.next;
          }
          if (cur == null) break;

          // from cur.next, delete n nodes
          ListNode tmp = cur;
          for (int i = 0; i < n && tmp.next != null; i++) {
              tmp = tmp.next;
          }

          // connect cur -> tmp.next
          cur.next = tmp.next;
          cur = cur.next; // move to next round
      }
      return head;
  }
}
