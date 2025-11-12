// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/linked-list-cycle/

class Solution {
    // Two pointers -> fast go 2 steps, slow go 1 step
    // If there is a cycle, the two pointers will meet at one point
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
