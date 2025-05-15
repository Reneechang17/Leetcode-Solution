// Medium
// LinkedList
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;

        while (cur != null) {
            // skip duplicates
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // check if skip duplicates
            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
