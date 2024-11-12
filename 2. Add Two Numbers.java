// Medium
// LinkedList
// O(n)
// https://leetcode.cn/problems/add-two-numbers/

class Solution {
    // 首先這題不能想的太複雜，也就是可以不要太在意那個反轉的問題
    // 這題可以看成竪式的加法，但需要處理進位的問題
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode cur = dummy; // cur to store the res

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
