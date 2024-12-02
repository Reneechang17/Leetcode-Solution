// Easy
// Linked List
// Time:O(m+n), Space:O(1)
// https://leetcode.cn/problems/merge-two-sorted-lists/

class Solution {
    // Iterate list1 and list2, and compare which is smaller one be the next
    // finally check which list is not going to end, than add the remain part to tail
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }
        return dummy.next;
    }
}
