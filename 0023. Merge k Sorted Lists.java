// Hard
// Min Heap
// Time:O(nlongk), Space:O(k)
// https://leetcode.cn/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;
class Solution {
    // Use minHeap to always get the smallest one from lists
    // Each time get smallest one from heap, and add its next node to que if exist
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) heap.add(head);
        }

        ListNode dummy = new ListNode(-1), cur = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll(); 
            cur.next = node;
            cur = cur.next;
            if (node.next != null) heap.add(node.next);
        }
        return dummy.next;
    }
}
