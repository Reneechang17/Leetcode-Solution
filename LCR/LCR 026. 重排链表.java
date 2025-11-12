// Medium
// LinkedList, Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/LGjMqU/

class Solution {
    // find middle -> reverse linkedlist -> merge
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = findMid(head);
        ListNode l1 = head, l2 = mid.next;
        mid.next = null; // break l1 and l2 by point l1's end to null
        l2 = reverse(l2);
        merge(l1, l2);
    }
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
    private void merge(ListNode l1, ListNode l2) {
        ListNode l1tmp, l2tmp;
        while (l1 != null && l2 != null) {
            l1tmp = l1.next;
            l2tmp = l2.next;
            
            l1.next = l2;
            l1 = l1tmp;

            l2.next = l1;
            l2 = l2tmp;
        }
    }
}
