// Medium
// Binary Tree, Recursion
// O(n)
// https://leetcode.com/problems/binary-tree-upside-down/

class Solution {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
      if (root == null || root.left == null) {
          return root;
      }
      
      // 遞歸到最左邊的葉子節點
      TreeNode newRoot = upsideDownBinaryTree(root.left);
      root.left.left = root.right; // 原樹的右子節點成為新的左子節點
      root.left.right = root; // 原樹的根節點成為新的右子節點
      root.left = null; // 清除原樹根節點的左子節點
      root.right = null; // 清除原樹根節點的右子節點
      return newRoot; // 返回新樹的根節點
  }
}

/**
 * 二叉樹的上下翻轉：在新的樹中，原樹的左子節點成為新的根節點，原樹的根節點成為新樹的右子節點，原樹的右子節點成為新樹的左子節點
 * 
 * 乍看之下可能會覺得很難，這時候可以考慮比較暴力的方式或是遞歸，這裡使用遞歸，結合題目要求的交換規則
 * 解法的核心思想是透過遞歸從最左邊的葉子節點（新的根節點）開始，逐層向上構建新的樹
 **/