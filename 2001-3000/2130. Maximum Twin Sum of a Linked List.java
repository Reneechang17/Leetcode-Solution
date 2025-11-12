// Medium
// LinkedList
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/

class Solution {
    public int pairSum(ListNode head) {
        // slow-fast pointers to break linkedlist to two part and reverse second part
        // no need to skip mid cuz the it is even length
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow);

        int maxSum = 0;
        ListNode first = head;
        while (second != null) {
            maxSum = Math.max(first.val + second.val, maxSum);
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
 
    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
