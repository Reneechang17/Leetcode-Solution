// Medium
// Linked List, Simulation
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/partition-list/

class Solution {
    // create two dummy linkedlist, one store the node smaller than x
    // one store the node equal and bigger than x, then connect them together
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode bigDummy = new ListNode(-1);

        ListNode smaller = smallDummy;
        ListNode bigger = bigDummy;

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
        // set the last node's next pointer to null
        bigger.next = null;
        smaller.next = bigDummy.next;
        return smallDummy.next;
    }
}
