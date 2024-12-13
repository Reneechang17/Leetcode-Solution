// Hard
// Min Heap
// Time:O(nlongk), Space:O(k)
// https://leetcode.cn/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

class Solution {
    // Use pq(min-heap) to always get the smallest element from all lists
    // Each time take the smallest one from heap, and add its next node to que if exist
    // This ensures we always maintain the sorted order
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // add head of each list to pq
        for (ListNode head : lists) {
            if (head != null) pq.offer(head);
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll(); // get the smallest node
            cur.next = node;
            cur = cur.next;
            // add the next of node to que if exist
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
