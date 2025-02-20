// Medium
// LinkedList
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/swap-nodes-in-pairs/

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode temp, firstNode, secondNode;

        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;

            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;

            cur = firstNode;
        }
        return dummy.next;
    }
}
