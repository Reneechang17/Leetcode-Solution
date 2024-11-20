// Medium
// LinkedList
// Time: O(n), Space: O(1)
// https://leetcode.cn/problems/rotate-list/

class Solution {
  // 这题可以用快慢指针做，先让快指针走k步，然后快慢指针一起走
  // 当快指针走到结尾时，慢指针的下一个节点就是新链表的头节点
  public ListNode rotateRight(ListNode head, int k) {
      if (head == null || head.next == null) {
          return head;
      }

      ListNode cur = head;
      int n = 0; 
      for (; cur != null; cur = cur.next) {
          n++;
      }

      k %= n;
      if (k == 0) {
          return head;
      }

      ListNode fast = head, slow = head;
      while (k > 0) {
          fast = fast.next;
          k--;
      }
      while (fast.next != null) {
          fast = fast.next;
          slow = slow.next;
      }

      ListNode ans = slow.next;
      // 将旧链表的倒数第k个节点（slow所在节点）与倒数k+1（slow.next)断开
      // 链表会有两个部分：一个是原本头节点～slow，以及slow.next～原本链表末尾
      slow.next = null;
      // 此时fast会在链表最后一个节点，我们要把原本链表的末尾节点和原本链表的头节点连在一起
      fast.next = head;
      return ans;
  }
}
