// Easy
// Tree, Recursion
// O(n)
// https://leetcode.com/problems/count-complete-tree-nodes/

class Solution {
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return countNodes(root.left) + countNodes(root.right) + 1;
  }
}

/**
 * 這題是統計完全二叉樹的節點個數
 * 可以用遞歸和迭代做
 * 
 * 補充：完全二叉樹
 * 定義：除了最底層節點可能沒填滿以外，其餘每層節點數都達到最大值，並且最下層的節點都集中在該層最左邊的若干位置。若對底層為第h層，則該層包含1~ 2^(h-1) 個節點
 * 
 * 完全二叉樹的兩種節點情況 1. 滿二叉樹：2^樹深度 - 1  
 * 2. 最後一層葉子節點沒有滿：分別遞歸左孩子和右孩子，遞歸到某一個深度一定會有左孩子或是右孩子為滿二叉樹
 **/