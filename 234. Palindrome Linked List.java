// Easy
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/palindrome-linked-list/

class Solution {
    // Use slow and fast pointer to find the middle of list
    // Reverse the second half of the list
    // Compare the first half and second half for validation
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // if the length is odd, move slow one step further
        if (fast != null) {
            slow = slow.next;
        }
        ListNode first = head;
        ListNode second = reverse(slow);
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
    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
}
