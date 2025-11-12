// Easy
// LinkedList
// Time:O(n + k),Space:O(k)
// https://leetcode.cn/problems/linked-list-frequency/

import java.util.*;
class Solution {
    // Use map to calculate the freq
    // Then build the new LinkedList, the node val is freq
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1), tail = dummy;
        for (int freq : map.values()) {
            tail.next = new ListNode(freq);
            tail = tail.next;
        }
        return dummy.next;
    }
}
