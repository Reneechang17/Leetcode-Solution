// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/

class Solution {
    // Use two pointers, start from the dummy node, and fast pointer move n steps ahead
    // Then move both pointers until the fast reaches null
    // at this time, the slow pointer will locate in the node which just before the target node(need to delete)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
