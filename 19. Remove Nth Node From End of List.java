// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/

class Solution {
    // Use two pointers(fast and slow), both start at dummy node
    // Move the fast pointer 'n+1' steps head and maintain a gap of n nodes
    // Move both pointers together until fast reaches the end
    // The slow pointer will be before the target node, which can be removed
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
