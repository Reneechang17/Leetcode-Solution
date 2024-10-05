// Medium
// DFS
// O(n)
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class Solution {
  public void flatten(TreeNode root) {
      if (root == null) return;

      flatten(root.left);
      flatten(root.right);

      TreeNode temp = root.right;

      root.right = root.left;
      root.left = null;

      TreeNode cur = root;
      while (cur.right != null) {
          cur = cur.right;
      }

      cur.right = temp;
  }
}

/**
 * 將二叉樹展開為鏈表：給定一個二叉樹，用前序遍歷的方式展開為一個單鏈表，樹中的左子節點需要設置為null，右子節點用來串連原樹的節點
 * 
 * 思路：這題用遞歸或是迭代都可以，重點在於前序遍歷
 * 遞歸：遞歸展開左子樹和右子樹，然後將左子樹插入到根節點和右子樹之間
 * 
 * 展開左子樹並將它接到根節點和右子樹中間
 * 將左子樹設為null
 * 然後遍歷到新的右子樹的最右節點，將原來的右子樹接到這個節點的右子樹
 **/