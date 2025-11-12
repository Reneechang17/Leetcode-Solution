// Easy
// LinkedList
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/UHnkqh/

class Solution {
    public ListNode reverseList(ListNode head) {
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
