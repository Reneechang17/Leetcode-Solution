// Hard
// LinkedList
// O(n)
// https://leetcode.com/problems/reverse-nodes-in-k-group/

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode start = head, end = head;
        // find the k group
        for (int i = 0; i < k; i++) {
            // base case: if not enough
            if (end == null)
                return head;
            end = end.next;
        }

        // reverse the k group with helper function
        ListNode newHead = reverse(start, end);

        // connect
        start.next = reverseKGroup(end, k);
        return newHead;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre, cur, next;
        pre = null;
        cur = start;
        next = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

/**
 * 思路：
 * 1. 遍歷先找區間
 * Note:注意不夠k的情況
 * 2. Helper Function 反轉區間
 * 3. 新的頭（舊的尾）和鏈表繼續（start的next）接上（難點）
 **/
