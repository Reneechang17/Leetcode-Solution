// Medium
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/odd-even-linked-list/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            // 1-2-3-4-5
            odd.next = even.next; // 1-3
            odd = odd.next; // odd = 3
            even.next = odd.next; // 2-4
            even = even.next; // even = 4
        }
        odd.next = evenHead;
        return head;
    }
}
