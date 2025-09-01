// Medium
// LinkedList
// Time: O(n), Space: O(n)
// https://leetcode.cn/problems/remove-duplicates-from-an-unsorted-linked-list/

import java.util.*;

class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> cnt = new HashMap<>();
        
        countFreq(head, cnt);

        return removeDuplicates(head, cnt);
    }

    private void countFreq(ListNode head, Map<Integer, Integer> cnt) {
        if (head == null) return;
        cnt.put(head.val, cnt.getOrDefault(head.val, 0) + 1);
        countFreq(head.next, cnt);
    }

    private ListNode removeDuplicates(ListNode head, Map<Integer, Integer> cnt) {
        if (head == null) return null;

        if (cnt.get(head.val) > 1) {
            // skip
            return removeDuplicates(head.next, cnt);
        } else {
            head.next = removeDuplicates(head.next, cnt);
            return head;
        }
    }
}
