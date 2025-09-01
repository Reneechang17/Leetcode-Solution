// Medium
// LinkedList
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        if (head.val == head.next.val) {
            int val = head.val;
            // [1,2,2,2,3,3,4,4,5]
            while (head != null && head.val == val) {
                head = head.next;
            }
            return deleteDuplicates(head);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
