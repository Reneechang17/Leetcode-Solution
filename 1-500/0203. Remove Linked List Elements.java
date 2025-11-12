// Easy
// LinkedList
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/remove-linked-list-elements/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        // since the removeNode maybe the head one
        // so set dummy as head
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
