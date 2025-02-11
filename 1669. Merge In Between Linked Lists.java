// Medium
// LinkedList
// Time:O(n+m),Space:O(1)
// https://leetcode.cn/problems/merge-in-between-linked-lists/

class Solution {
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
      ListNode prevA = list1, afterB = list1;
      // find the a-1 pos
      for (int i = 0; i < a - 1; i++) {
          prevA = prevA.next;
      }
      // find the b+1 pos
      afterB = prevA.next;
      for (int i = a; i <= b; i++) {
          afterB = afterB.next;
      }

      // connect list1[a-1] -> list2
      prevA.next = list2;

      // find the tail of list2
      ListNode tail = list2;
      while (tail.next != null) {
          tail = tail.next;
      }

      // connect list2' tail -> list1[b+1]
      tail.next = afterB;
      return list1;
  }
}
