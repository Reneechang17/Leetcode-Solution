// Medium
// Tree, BST. LinkedList
// O(n)
// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null)
      return null; // 沒有
    if (head.next == null)
      return new TreeNode(head.val); // 只有一個

    ListNode pre = null, slow = head, fast = head;
    // find mid
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    // disconnect the left part
    if (pre != null) {
      pre.next = null;
    }

    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);

    return root;
  }
}
 
/**
 * 將有序鏈表轉換成一個BST
 * 
 * 即然已經有序了比較好辦，關鍵在於找鏈表的中點作為BST的根節點
 * 鏈表找中點的方法：雙指針，快指針走2慢指針走1
 * 再定義一個pre紀錄左鏈表的最後一個節點（之後disconnect要用）
 * 這樣最後slow.val就是新的BST的根節點，head～pre就是左子樹（繼續遞歸）slow.next～鏈表結尾就是右子樹（繼續遞歸）
 **/
