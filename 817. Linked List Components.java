// Medium
// Hash Table, LinkedList
// Time:O(n + m),Space:O(m)
// https://leetcode.cn/problems/linked-list-components/

import java.util.*;
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        // for O(1) lookup
        for (int n : nums) {
            set.add(n);
        }
        int count = 0;
        while (head != null) {
            // only when cur in nums, and its next is not in nums
            // then add count
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                count++;
            }
            head = head.next;
        }
        return count;
    }
}
