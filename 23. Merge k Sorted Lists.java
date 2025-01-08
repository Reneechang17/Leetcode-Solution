// Hard
// Min Heap(PriorityQueue)
// Time:O(nlongk), Space:O(k)
// https://leetcode.cn/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

class Solution {
    // Use pq(min-heap) to always get the smallest element from all lists
    // Each time take the smallest one from heap, and add its next node to que if exist
    // This ensures we always maintain the sorted order
    public ListNode mergeKLists(ListNode[] lists) {
        // basecase
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        // add head of each list to pq
        for (ListNode head : lists) {
            if (head != null) minHeap.add(head);
        }
        // Build res list
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // get the smallest one
            cur.next = node;
            cur = cur.next;
            if (node.next != null) minHeap.add(node.next);
        }
        return dummy.next;
    }
}

// 因為每一個list都是有序的，相當於多路歸併成一個整個有序的list，可以用優先隊列
// minHeap來找出最小的head，然後再將其下一個元素加入minHeap中
