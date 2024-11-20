// Medium
// Linked List
// Time: O(n), Space: O(1)
// https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/

class Solution {
  public ListNode deleteDuplicates(ListNode head) {
      ListNode dummy = new ListNode(0, head);
      ListNode prev = dummy; // 指向已确认不重复的节点

      while (head != null && head.next != null) {
          if (head.val == head.next.val) {
              // 跳过所有重复节点
              while (head.next != null && head.val == head.next.val) {
                  head = head.next;
              }
              // 跳过重复的最后一个节点
              prev.next = head.next;
          } else {
              // 当前节点不重复，则移动prev
              prev = prev.next;
          }
          // 移动head
          head = head.next;
      }
      return dummy.next;
  }
}
