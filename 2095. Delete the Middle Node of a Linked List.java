// Medium
// LinkedList, Two Pointers
// O(n)
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

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

/**
 * 快慢指針，快指針一次走兩步，慢指針一次走一步
 * 快指針初始在實際頭節點，慢指針初始在dummy，讓慢指針停留在middle的前一個節點，方便做刪除操作
 **/