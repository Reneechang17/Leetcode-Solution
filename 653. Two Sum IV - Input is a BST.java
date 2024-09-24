// Easy
// DFS, Hash Table
// O(n)
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

import java.util.HashSet;
import java.util.Set;

class Solution {
  private Set<Integer> vis = new HashSet<>();
  private int k;

  public boolean findTarget(TreeNode root, int k) {
      this.k = k;
      return dfs(root);
  }

  private boolean dfs (TreeNode root) {
      if (root == null) {
          return false;
      }
      if (vis.contains(k - root.val)) {
          return true;
      }
      vis.add(root.val);
      return dfs(root.left) || dfs(root.right);
  }
}

/**
 * 二叉搜索樹中找兩數之和：給定BST和target數k，如果BST中存在兩個數字的和等於k，則返回true，否則返回false
 * 
 * 思路：這題應該可以聯想出很多解法，對於樹這題可以DFS也可以BFS，由於他是BST，也可以中序遍歷得到一個有序的數組，然後用雙指針（follow-up）
 * 至於兩數之和的解法是哈希表，在遍歷的過程中，將當前值加入哈希表中，去搜索它的另一半k-root.val是否存在於哈希表中
 * 這裡用DFS+哈希表做比較直觀
 **/