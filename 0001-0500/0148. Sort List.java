// Medium
// Two Pointers, LinkedList
// Time:O(nlogn),Space:O(logn)call stack
// https://leetcode.cn/problems/sort-list/

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // use slow-fast pointers to find the mid of the list
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // recursively apply merge sort on left and right sublists
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // merge two lists
        return merge(left, right);
    }
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return dummy.next;
    }
}
