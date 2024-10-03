// Medium
// LinkedList
// O(n)
// https://leetcode.cn/problems/add-two-numbers/

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      int carry = 0; // carry用來保存進位

      while (l1 != null || l2 != null) {
          int x = (l1 != null) ? l1.val : 0;
          int y = (l2 != null) ? l2.val : 0;

          // 計算當前位的和，考慮進位
          int sum = x + y + carry;
          carry = sum / 10; // 計算進位
          cur.next = new ListNode(sum % 10); // 當前位的結果是 sum%10
          cur = cur.next;

          // 移動鏈表l1和l2的指針
          if (l1 != null) l1 = l1.next;
          if (l2 != null) l2 = l2.next;
      }
      // 如果最後還有進位，需要額外的節點
      if (carry > 0) {
          cur.next = new ListNode(carry);
      }

      return dummy.next; // 返回新鏈表的頭節點
  }
}

/**
 * 鏈表相加：給定兩個鏈表，每個鏈表中的節點表示一個逆序存儲的數字，需要將兩個鏈表對應的數字相加，並將結果作為一個新的鏈表返回，每個節點只存儲一個數字
 * 
 * 思路：首先可以根據圖理解題目，為了更容易理解可以將這個問題類比成算術中兩數相加時的竪式計算，每一位都從低位開始相加，遇到進位時將進位加到下一位上
 **/