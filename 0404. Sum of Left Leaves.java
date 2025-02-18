// Easy
// Tree
// O(N)
// https://leetcode.com/problems/sum-of-left-leaves/

class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
      if (root == null) return 0;
      int leftTree = sumOfLeftLeaves (root.left);
      int rightTree = sumOfLeftLeaves(root.right);
      
      int mid = 0;
      if (root.left != null && root.left.left == null && root.left.right == null) {
          mid = root.left.val;
      }

      int ans = mid + leftTree + rightTree;
      return ans;
  }
}

/**
 * 左葉子的和
 * 
 * 要先判斷一個節點是不是左葉子：節點A的左孩子不為空，並且左孩子的左右孩子都為空，那麼節點A的左孩子就是左葉子
 * Note：無法根據當前節點判斷它是不是左葉子的，必須要通過當前節點的父節點來判斷其左孩子是不是左葉子
 * 透過遞歸找左子樹的左葉子和 & 右子樹的左葉子和，加在一起就是total
 **/