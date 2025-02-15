// Medium
// LinkedList
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/remove-nodes-from-linked-list/

class Solution {
    // Reverse the linkedlist, then remove nodes where 
    //  - list[i]>list[i+1], remove list[i]
    //  - finally reverse back
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode cur = head;
        int curVal = cur.val;
        while (cur.next != null) {
            if (curVal > cur.next.val) {
                cur.next = cur.next.next; // remove list[i]
            } else {
                // update curVal as cur.next.val and move cur
                curVal = cur.next.val;
                cur = cur.next;
            }
        }
        return reverse(head);
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
