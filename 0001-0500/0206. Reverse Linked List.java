// Easy
// LinkedList
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/reverse-linked-list/

class Solution {
    public ListNode reverseList(ListNode head) {
        // need a pre node first point to null, cuz the first node should point to null
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next; // save for move
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
