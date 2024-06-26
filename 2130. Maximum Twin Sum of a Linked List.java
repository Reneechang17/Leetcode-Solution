// Medium
// LinkedList, Two Pointers
// O(n)
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

class Solution {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public int pairSum(ListNode head) {
    // 1. Find the middle of the LinkedList
    // (Two Pointer: fast go two and slow go one) 
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // 2. Reserve the part after middle of the LinkedList
    // use helper function
    ListNode second = reverse(slow);
    // 3. Iterate two LinkedList and update the maxSum
    int maxSum = 0;
    ListNode first = head;
    while (second != null) {
      maxSum = Math.max(maxSum, first.val + second.val);
      first = first.next;
      second = second.next;
    }
    return maxSum;

  }

  private ListNode reverse(ListNode head) {
    ListNode pre = null, cur = head;
    while (cur != null) {
      ListNode curNext = cur.next;
      cur.next = pre;
      pre = cur; // Move pre forward
      cur = curNext; // Move cur forward
    }
    return pre;
  }
}

/**
 * 1. 先找鏈表的中點（這題已經說鏈表長度為偶數了所以快走2慢走1就可以）
 * 2. 反轉slow後的後半部鏈表
 * 3. 同時遍歷兩個鏈表，並更新最大值
 **/