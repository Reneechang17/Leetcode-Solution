// Medium
// LinkedList
// Time:O(n),Space:O(k)
// https://leetcode.cn/problems/split-linked-list-in-parts/

class Solution {
  public ListNode[] splitListToParts(ListNode head, int k) {
      ListNode[] res = new ListNode[k];
      // calculate the length of linkedlist
      int n = 0;
      ListNode cur = head;
      while (cur != null) {
          n++;
          cur = cur.next;
      }
      // calculate the part size
      int base = n / k;
      int extra = n % k; // first extra part need one more
      // split the linkedlist
      cur = head;
      for (int i = 0; i < k; i++) {
          ListNode dummy = new ListNode(0);
          ListNode tail = dummy;
          int partSize = base + (i < extra ? 1 : 0);

          for (int j = 0; j < partSize; j++) {
              tail.next = cur;
              tail = tail.next;
              if (cur != null) {
                  cur = cur.next;
              }
          }
          // cut the cur part
          if (tail != null) tail.next = null;
          res[i] = dummy.next;
      }
      return res;
  }
}
