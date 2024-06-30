// Hard
// LinkedList, Heap
// O(n longk)
// https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
      for (ListNode head : lists) {
          if (head != null) {
              pq.offer(head);
          }
      }
      ListNode dummy = new ListNode();
      ListNode cur = dummy;
      while (!pq.isEmpty()) {
          ListNode node = pq.poll();
          if (node.next != null) {
              pq.offer(node.next);
          }
          cur.next = node;
          cur = cur.next;
      }
      return dummy.next;
  }
}

/**
 * 本題給出一個鏈表數組，每個鏈表都已經按照升序排序。將所有鏈表合併到一個升序鏈表中，最後返回合併後的鏈表
 * 
 * 代碼使用小根堆來維護所有鏈表的頭節點，每次從小根堆中取出值最小的節點，添加到結果鏈表的末尾，然後將該節點的下一個節點加入堆中，重複上述步驟直到堆為空
 * 
 * 具體操作：
 * 1. 開一個優先隊列並按照升序排列，隊列的第一個元素是最小元素
 * 2. 初始化優先隊列，遍歷所有列表的頭節點，把非空節點放到優先隊列中，這樣優先隊列會包含每個鏈表中的最初元素（也是最小，因為每個鏈表都已經升序排好了）
 * 3. 創建虛擬頭節點，並把虛擬頭節點賦值給cur
 * 4. 處理優先隊列中的節點：從隊列中取出並移除當前最小的節點，如果這個節點之後還有節點，則將下一個節點加入優先隊列中，以便後續參與比較
 * 將取出的節點連接到合併鏈表中，並更新cur指針到鏈表的最新節點，最後返回合併後的鏈表
 **/