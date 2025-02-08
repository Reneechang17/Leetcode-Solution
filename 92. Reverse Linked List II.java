// Medium
// LinkedList
// Time: O(n), Space: O(1)
// https://leetcode.cn/problems/reverse-linked-list-ii/

class Solution {
    // First to find the node before left
    // Reverse the sublist from left to right
    // Connect the reversed part back to the original list
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // basecase
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode first = pre.next; // first point to left pos
        ListNode second = first.next;

        // reverse left to right
        for (int i = 0; i < right- left; i++) {
            // orig: pre - first - sec - third
            // goal: pre - third - sec - first
            first.next = second.next; // skip second -> first - third -> first - null
            second.next = pre.next; // insert sec behind pre -> sec - first -> third - sec
            pre.next = second; // pre connect sec -> pre - sec - first - third -> pre - third
            second = first.next; // move sec -> new sec: third -> pre - third - sec - fisrt
        }
        return dummy.next;
    }
}
