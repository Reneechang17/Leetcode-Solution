// Medium
// LinkedList
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/add-two-numbers/

class Solution {
    // Iterates lists, sum the corresponding digits with carry from prev operation
    // and constructs a new linked list to represent the result
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // If there's a leftover carry after process lists, added as a new node at the end
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
