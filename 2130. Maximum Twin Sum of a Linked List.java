// Medium
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/

class Solution {
  public int pairSum(ListNode head) {
      ListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }
      ListNode sec = reverse(slow);

      int maxSum = 0;
      ListNode first = head;
      while (sec != null) {
          maxSum = Math.max(maxSum, first.val + sec.val);
          first = first.next;
          sec = sec.next;
      }
      return maxSum;
  }

  private ListNode reverse(ListNode head) {
      ListNode pre = null, cur = head;
      while (cur != null) {
          ListNode tmp = cur.next;
          cur.next = pre;
          pre = cur;
          cur = tmp;
      }
      return pre;
  }
}
