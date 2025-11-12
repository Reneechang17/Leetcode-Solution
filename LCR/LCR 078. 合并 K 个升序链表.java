// Hard
// Min Heap
// Time:O(nlongk), Space:O(k)
// https://leetcode.cn/problems/vvXgSW/

import java.util.PriorityQueue;

class Solution {
    // Use minHeap, each time get smallest from heap and add its next to que
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) minHeap.add(head);
        }

        ListNode dummy = new ListNode(-1), cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) minHeap.add(node.next);
        }
        return dummy.next;
    }
}
