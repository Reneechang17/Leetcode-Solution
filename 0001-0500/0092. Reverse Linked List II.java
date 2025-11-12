// Medium
// LinkedList
// Time: O(n), Space: O(1)
// https://leetcode.cn/problems/reverse-linked-list-ii/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // basecase
        if (head == null || left == right)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // find the node before left
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // reverse [left, right]
        ListNode prev = null, cur = pre.next, con = cur;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        // reconnect
        pre.next = prev; // the node before origin first should connect to the origin right
        con.next = cur; // the origin first to connect to the node after origin right

        return dummy.next;
    }
}
