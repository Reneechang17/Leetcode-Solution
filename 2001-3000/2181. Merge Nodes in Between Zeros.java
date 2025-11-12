// Medium
// LinkedList
// O(N)
// https://leetcode.com/problems/merge-nodes-in-between-zeros/

class Solution {
  public ListNode mergeNodes(ListNode head) {
      ListNode dummy = new ListNode(-1);
      ListNode cur = dummy;
      int sum = 0;

      head = head.next;

      while (head != null) {
          if (head.val != 0) {
              sum += head.val;
          } else {
              if (sum > 0) {
                  cur.next = new ListNode(sum);
                  cur = cur.next;
                  sum = 0;
              }
          }
          head = head.next;
      }
      return dummy.next;
  }
}

/**
 * 給定一個鏈表的頭節點head，這個鏈表由0分隔開，並且鏈表的開頭和結尾的節點都滿足node.val == 0
 * 需要做的是將每兩個0之間的節點合併成一個節點，其值為合併節點段的和，然後將所有的0都移除
 * 修改後的鏈表不應該含有任何0
 * 
 * 思路：
 * 可以用一個指針來遍歷鏈表，可以從head的下一個開始（直接跳過開頭的0），當遍歷到非零節點時，計算這些節點的值的和
 * 每當遇到一個零的時候，如果當前的和不是零，則在這個零節點之前插入一個新的節點，其值為計算出來的和，然後再重置和為0，繼續遍歷
 * 最後將合併後的新節點正確連接
 **/