// Hard
// Min Heap
// Time:O(nlongk), Space:O(k)
// https://leetcode.cn/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

class Solution {
    // Use min-heap to always get the smallest element from all lists
    // Each time we take the smallest one from heap, and add its next node to heap if exist
    // This ensures we always maintain the sorted order
    public ListNode mergeKLists(ListNode[] lists) {
        // basecase
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // add the head of each list to heap
        for (ListNode head : lists) {
            if (head != null) pq.offer(head);
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll(); // get the smallest node
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
