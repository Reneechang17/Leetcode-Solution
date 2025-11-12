// Medium
// LinkedList
// O(1)
// https://leetcode.com/problems/delete-node-in-a-linked-list/

class Solution {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public void deleteNode(ListNode node) {
    if (node == null)
      return;
    node.val = node.next.val;
    node.next = node.next.next;
  }
}

/**
 * 刪除鏈表中的節點
 * 本題的節點是直接通過節點引用提供，不是鏈表的頭節點和節點位置提供，也沒有鏈表的頭節點操作
 * 1. 複製欲刪除節點的下一個節點的值到欲刪除節點
 * 2. 將當前節點指向下下一個節點（跳過原本的下一個）
 **/