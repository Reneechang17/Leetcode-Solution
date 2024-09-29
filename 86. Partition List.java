// Medium
// Linked List
// O(n)
// https://leetcode.cn/problems/partition-list/

class Solution {
  public ListNode partition(ListNode head, int x) {
      ListNode smallDummy = new ListNode(-1);
      ListNode bigDummy = new ListNode(-1);

      ListNode smaller = smallDummy;
      ListNode bigger = bigDummy;

      while (head != null) {
          if (head.val < x) {
              smaller.next = head;
              smaller = smaller.next;
          } else {
              bigger.next = head;
              bigger = bigger.next;
          }
          head = head.next;
      }

      bigger.next = null;
      smaller.next = bigDummy.next;

      return smallDummy.next;
  }
}

/**
 * 分割鏈表：將鏈表分成兩部分，一部分所有節點的值小於x，另一部分所有節點的值大於等於x，並保持原本鏈表中節點的相對位置
 * 
 * 這題可以創建兩個虛擬頭節點，分別用於鏈接小於x的鏈表和大於等於x的鏈表
 * 遍歷原始鏈表，將小於x的節點連接到smaller鏈表，大於等於x的節點連接到bigger鏈表
 * 最後把兩個鏈表連起來，注意可以把bigger鏈表的尾節點的next指針指向null，這樣可以避免出現循環
 * 
 * 鏈表題一般都可以透過模擬完成，不用想的太複雜，只要保證鏈表的next指針正確即可
 **/