// Medium
// PrefixSum + HashMap
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

import java.util.*;
class Solution {
    // Use PrefixSum and HashMap, map store the prefixSum and its last appear pos
    // If the prefixSum repeats, we can remove that range 
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();

        int prefixSum = 0;
        ListNode cur = dummy;

        while (cur != null) {
            prefixSum += cur.val;
            map.put(prefixSum, cur);
            cur = cur.next;
        }

        prefixSum = 0;
        cur = dummy;
        while (cur != null) {
            prefixSum += cur.val;
            cur.next = map.get(prefixSum).next; // skip the between part
            cur = cur.next;
        }
        return dummy.next;
    }
}
