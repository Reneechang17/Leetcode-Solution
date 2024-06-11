// Medium
// LinkedList, Two Pointers
// O(n)
// https://leetcode.com/problems/rotate-list/

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

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    int n = 0;
    for (; cur != null; cur = cur.next) {
      n++;
    }

    k %= n;
    if (k == 0) {
      return head;
    }

    ListNode fast = head, slow = head;
    // let fast go ahead with k steps
    while (k > 0) {
      fast = fast.next;
      k--;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    ListNode ans = slow.next;
    slow.next = null;
    fast.next = head;
    return ans;
  }
}

/**
 * 思路：快慢指針
 * base case: 節點數小於2，返回head
 * 
 * 遍歷鏈表，統計鏈表的節點數n，將k對n取模，得到k的有效值
 * Note：如果有效值為0，則不需要rotate直接返回head
 * 
 * 快慢指針：讓快指針先走k步，然後快慢指針一起走
 * 當快指針走到結尾，則慢指針的下一個節點就是新的鏈表頭節點
 * 
 * slow.next = null;
 * ⬆️ 將舊鏈表的倒數第k個節點（slow所在節點）與倒數k+1（slow.next）個節點斷開，這樣鏈表會有兩個部分：分別是從原頭節點到slow，從slow.next到原鏈表的末尾
 * 
 * fast.next = head;
 * ⬆️ fast指針此時在鏈表的末尾，我們要將原本鏈表的末尾節點與原本鏈表的頭幾點連在一起
 * 
 * => 原來的後k個節點現在變成新的鏈表的前部分
 **/