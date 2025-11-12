// Medium
// LinkedList, Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/reorder-list/

class Solution {
    public void reorderList(ListNode head) {
        // split linkedlist into two parts
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;

        // reverse the second part
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur = head;

        // merge two linkedlists
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            cur = pre.next;
            pre = tmp;
        }
    }
}
