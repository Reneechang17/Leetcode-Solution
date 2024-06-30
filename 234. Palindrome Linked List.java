// Easy
// LinkedList, Two Pointers
// O(n)
// https://leetcode.com/problems/palindrome-linked-list/

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

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

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

/**
 * 回文鏈表:
 * 1. 找鏈表的中點：快指針走兩步慢指針走一步，最後慢指針停的地方就是中點
 * edge case：如果fast沒有走到null，代表鏈表長度為奇數，此時需要讓慢指針再走一步，避免後面那段鏈表包含mid
 * 2. 此時我們會有兩段鏈表，我們要把slow停的位置開始的第二段鏈表反轉
 * 3. 同時遍歷兩個鏈表，如果兩個鏈表遍歷到的值不相等，return false，不然就繼續走
 **/