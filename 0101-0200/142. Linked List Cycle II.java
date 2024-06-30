// Medium
// LinkedList, Two Pointers
// O(n)
// https://leetcode.com/problems/linked-list-cycle-ii/


class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                ListNode idx1 = fast;
                ListNode idx2 = head;
                while (idx1 != idx2) {
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx1;
            }
        }
        return null;
    }
}

/**
 * 此題需判斷
 * 1. 是否有環？
 * 2. 如果有環，入口在哪？
 * 
 * 具體做法：
 * 1. 快慢指針都從head出發，快指針每次走2，慢指針每次走1，如果相遇代表有環
 * 2. 重新定義雙指針，一個指針從上次相遇的位置走，另一個從head走，每次都走一步，重合處為環的入口
 **/