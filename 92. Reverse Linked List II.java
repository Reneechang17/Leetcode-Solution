// Medium
// LinkedList
// O(n)
// https://leetcode.com/problems/reverse-linked-list-ii/

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

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null)
      return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;

    for (int i = 0; i < left - 1; i++) {
      pre = pre.next;
    }

    ListNode first = pre.next;
    ListNode two = first.next;

    for (int i = 0; i < right - left; i++) {
      first.next = two.next;
      two.next = pre.next;
      pre.next = two;
      two = first.next;
    }
    return dummy.next;
  }
}

/**
 * 這題的left right把要反轉的區間確定
 * 思路：
 * 1. 找到left的前一個節點
 * 2. 反轉left ～ right的區間
 * 3. 連接反轉部分的頭和尾（在反轉過程中更新）
 * 
 * 反轉操作：
 * 假設要反轉的鏈表為 1 -> 2 -> 3 -> 4 -> 5，反轉2（left）～4（right）
 * 1. 先找到left的前一個也就是1，此時first就是2，two就是3
 * 2. 先讓first（2）指向two的下一個（4）（跳過two）
 * 3. 將two指向first（相當於把two插在pre和first中間）
 * => 3 -> 2 -> 4
 * 4. 此時pre.next就是原本的two（更新）
 * => 1 -> 3 -> 2 -> 4 -> 5
 * 5. 而two更新為原本的first.next（此時two為4）
 * 
 * 第二次循環（i = 1）
 * Note：此時first是2，two是4，pre是1
 * 1. first.next = two.next：先讓first（2）指向two的下一個（5）: 2 -> 5
 * 2. two.next = pre.next： 將two指向first : 4 -> 3
 * 3. pre.next = two： 此時pre.next就是原本的two: 1 -> 4 -> 3 -> 2 -> 5
 * 4. two = first.next： 而two更新為原本的first.next（此時two為5）
 **/