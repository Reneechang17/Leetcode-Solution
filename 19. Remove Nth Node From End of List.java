// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/

class Solution {
    // Use slow-fast pointers to maintain the gap of n nodes(fast go n+1 further)
    // Then move both pointers together until fast reaches the end
    // The slow one will stop before target node, which can be removed
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1), fast = dummy, slow = dummy;
        dummy.next = head;
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
