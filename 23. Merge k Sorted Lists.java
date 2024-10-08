// Hard
// LinkedList, PriorityQueue
// O(n longk)
// https://leetcode.cn/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 給定一個鏈表數組，每組鏈表都按照升序排序，要求把每組鏈表合併成一個升序的鏈表
        // 可以維護一個小根堆，每次都從小根堆中取最小的節點，添加到鏈表後面
        // 如果取出的節點後還有節點，則把下一個節點加入到小根堆中
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1), cur = dummy;
        while (!pq.isEmpty()) {
            // 取出最小的節點
            ListNode node = pq.poll();
            // 如果這個節點後還有節點，則把下一個節點加入到小根堆中
            if (node.next != null) {
                pq.offer(node.next);
            }
            // 把取出的節點接在鏈表後面
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}

/**
 * 給出一個鏈表數組，每個鏈表都已經按照升序排序。將所有鏈表合併到一個升序鏈表中，最後返回合併後的鏈表
 * 思路：代碼使用小根堆來維護所有鏈表的頭節點，每次從小根堆中取出值最小的節點，添加到結果鏈表的末尾，然後將該節點的下一個節點加入堆中，重複上述步驟直到堆為空
 **/
