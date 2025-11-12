// Medium
// LinkedList
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/reverse-nodes-in-even-length-groups/

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // the point is expectedSize actually not same as the actualSize
        int expectedSize = 1;
        while (pre.next != null) {
            ListNode tmp = pre.next;
            int actualSize = 0;
            while (tmp != null && actualSize < expectedSize) {
                actualSize++;
                tmp = tmp.next;
            }

            // if even -> reverse
            if (actualSize % 2 == 0) {
                pre = reverse(pre, actualSize);
            } else {
                // move to the end of this group
                for (int i = 0; i < actualSize; i++) {
                    pre = pre.next;
                }
            }
            expectedSize++;
        }
        return dummy.next;
    }

    // reverse n's node after prev, return the new tail(origin first)
    private ListNode reverse(ListNode prev, int n) {
        ListNode first = prev.next;
        ListNode cur = first.next;

        for (int i = 0; i < n - 1; i++) {
            ListNode tmp = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = tmp;
        }
        first.next = cur;
        return first;
    }
}