// Easy
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/palindrome-linked-list/

class Solution {
    public boolean isPalindrome(ListNode head) {
        // use fast-slow pointers to find the mid point
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // if odd number, slow need to move forward
        // we don't need to check the mid node if odd
        if (fast != null)
            slow = slow.next;

        ListNode first = head, second = reverse(slow);
        while (second != null) {
            if (first.val != second.val) {
                return false;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
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
