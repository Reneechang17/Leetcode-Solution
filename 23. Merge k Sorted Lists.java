// Hard
// PriorityQueue
// Time:O(nlongk), Space:O(k)
// https://leetcode.cn/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // given a list of sorted linked lists, merge them into a single sorted linked list
        // use a min heap to store the nodes, and each time take the smallest node from the heap then add it to the list
        // if the node has next node, add the next node to the heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1), cur = dummy;
        while (!pq.isEmpty()) {
            // get the smallest node
            ListNode node = pq.poll();
            // if the node has next node, add the next node to the heap
            if (node.next != null) {
                pq.offer(node.next);
            }
            // add the node to the list
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
