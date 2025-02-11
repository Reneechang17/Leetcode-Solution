// Medium
// LinkedList, Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/

class Solution {
  public ListNode swapNodes(ListNode head, int k) {
      ListNode firstK = head, lastK = head;
      // if we start from 0, it would be the k+1's node
      int cnt = 1;

      while (cnt < k) {
          firstK = firstK.next;
          cnt++;
      }

      ListNode cur = firstK;
      while (cur.next != null) {
          lastK = lastK.next;
          cur = cur.next;
      }

      // swap the value
      int tmpVal = firstK.val;
      firstK.val = lastK.val;
      lastK.val = tmpVal;
      return head;
  }
}
