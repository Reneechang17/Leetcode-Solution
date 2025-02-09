// Medium
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/linked-list-cycle-ii/

class Solution {
    // Check cycle: if fast(2steps) and slow(1step) meet
    // Find entry: reset one pointer to head, move both of them
    //   one step each time until they meet
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode idx1 = fast;
                ListNode idx2 = head;
                while (idx1 != idx2) {
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx1;
            }
        }
        return null;
    }
}
