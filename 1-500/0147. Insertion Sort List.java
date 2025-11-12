// Medium
// Sorting, LinkedList
// Time:O(n^2),Space:O(1)
// https://leetcode.cn/problems/insertion-sort-list/

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode prev = dummy;
            ListNode next = cur.next;
            // find the insertion pos
            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }
            // insert node
            cur.next = prev.next;
            prev.next = cur;
            // process next one
            cur = next;
        }
        return dummy.next;
    }
}
