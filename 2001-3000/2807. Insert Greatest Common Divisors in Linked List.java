// Medium
// LinkedList
// Time:O(n * log(max(val))), Space:O(1)
// https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/

// Fine the hardest thing is: how to find greatest common divisors LOL:>
// Probably only for me:> Hopefully there is another guy who dont know gcd formula as well:D

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // basecase
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;

        // iterate linkedlist and insert the GCD nodes
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;

            int gcdVal = calculateGCD(cur.val, next.val);

            ListNode gcdNode = new ListNode(gcdVal);

            cur.next = gcdNode;
            gcdNode.next = next;

            cur = next; // skip the gcdNode
        }
        return head;
    }

    // REMEMBER PLEASE!
    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}
