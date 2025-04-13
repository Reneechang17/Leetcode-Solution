// Easy
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/palindrome-linked-list/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next; // if odd, slow move forward
        ListNode first = head, sec = reverse(slow);
        while (sec != null) {
            if (first.val != sec.val) {
                return false;
            } else {
                first = first.next;
                sec = sec.next;
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
