// Medium
// LinkedList
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/partition-list/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1), bigDummy = new ListNode(-1);
        ListNode smaller = smallDummy, bigger = bigDummy;
        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        bigger.next = null;
        smaller.next = bigDummy.next;
        return smallDummy.next;
    }
}
