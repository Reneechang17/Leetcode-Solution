// Medium
// LinkedList, Stack
// https://leetcode.cn/problems/add-two-numbers-ii/

import java.util.Stack;

class Solution {
  // Similar to Leetcode 2, but we can reverse the LinkedList first
  // Time:O(m+n), Space:O(1)
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    l1 = reverse(l1);
    l2 = reverse(l2);

    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int sum = carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      carry = sum / 10;
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
    }
    return reverse(dummy.next);
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null, cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}

class Solution2 {
  // Use stack to simulate the reverse process
  // Time:O(max(m, n)), Space:O(max(m, n))
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      Stack<Integer> stack1 = new Stack<>();
      Stack<Integer> stack2 = new Stack<>();

      // push the linkedlist value in stack
      while (l1 != null) {
          stack1.push(l1.val);
          l1 = l1.next;
      }
      while (l2 != null) {
          stack2.push(l2.val);
          l2 = l2.next;
      }

      ListNode dummy = null;
      int carry = 0;
      while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
          int num1 = stack1.isEmpty() ? 0 : stack1.pop();
          int num2 = stack2.isEmpty() ? 0 : stack2.pop();
          int sum = num1 + num2 + carry;
          carry = sum / 10;

          ListNode newNode = new ListNode(sum % 10);
          newNode.next = dummy;
          dummy = newNode;
      }
      return dummy;
  }
}
