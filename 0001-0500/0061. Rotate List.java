// Medium
// LinkedList
// Time: O(n), Space: O(1)
// https://leetcode.cn/problems/rotate-list/

class Solution {
    // Use fast-slow pointers to find the new head
    // break and reconnect the list to rotate it
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        // calculate the len of linkedlist
        ListNode cur = head;
        int n = 0;
        for (; cur != null; cur = cur.next) {
            n++;
        }
        k %= n;
        if (k == 0) return head;

        // apply fast-slow pointers
        ListNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow.next is the new head, and cut the slow.next to break the linkedlist
        // if will be original head~slow and slow.next~end -> two parts
        ListNode res = slow.next;
        slow.next = null;
        // at this time, fast will stop at last node, and reconnect it to head
        fast.next = head;
        return res;
    }
}
