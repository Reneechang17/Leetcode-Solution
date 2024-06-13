// Medium
// LinkedList, Two Pointers
// O(n)
// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

class Solution {
  public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
  public ListNode swapNodes(ListNode head, int k) {
      ListNode first = head, second = head;
      ListNode cur = head;

      // use cur to find k
      for(int i = 1; i < k; i++){
          cur = cur.next; // now, cur point to k
      }
      first = cur; 

      // find the k from end: cur keep going til end and second join
      // At the end, the second point to the k from the end
      while(cur.next != null){
          cur = cur.next;
          second = second.next; 
      }

      // swap two value
      int temp = first.val;
      first.val = second.val;
      second.val = temp;

      return head;
  }
}

/**
 * 這題需要交換頭k & 尾k的節點
 * 難點：怎麼找到鏈表中的頭k & 尾k？？？
 * 
 * 方法：定義first & second當作定位頭尾k，以及cur，初始化都是=head
 * 1. 先用cur走k步，從頭開始找到頭k（i不是從0是因為我們把第一個節點當成1而不是0，自然k-1就要➕1回來，即k）
 *    結束之後cur停的地方就是頭k的位置，讓first = cur
 * 2. cur找到頭k後，加入second一起走，當cur走到結尾的時候，second停的地方就是尾k的節點
 * 3. 直接swap first和second的val完成交換
 **/