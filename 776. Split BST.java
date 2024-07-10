// Medium
// Tree,BST, Recursion
// O(n)
// https://leetcode.com/problems/split-bst/

class Solution {
  private int t;

  public TreeNode[] splitBST(TreeNode root, int target) {
      t = target;
      return dfs(root);
  }

  private TreeNode[] dfs (TreeNode root) {
      if (root == null) {
          return new TreeNode[] {null, null};
      }
      if (root.val <= t) {
          TreeNode[] ans = dfs(root.right);
          root.right = ans[0];
          ans[0] = root;
          return ans;
      } else {
          TreeNode[] ans = dfs (root.left);
          root.left = ans[1];
          ans[1] = root;
          return ans;
      }
  }
}

/**
 * 給定一個二叉搜索樹的根節點和一個target數字，要求將樹拆分為兩個子樹：其中第一個子樹節點的值必須小於等於target，另一個子樹的節點值必須都大於等於target
 * 樹中並非一定存在為target的節點
 * 除此之外，樹的結構必須保留，也就是原始樹中父節點p的任意子節點c，假如拆分後他們孩子一個子樹中，p依舊是c的父節點
 * 按照順序返回兩個子樹的根節點的數組
 * 
 * 思路：這題可以直接用遞歸寫
 * 每次遞歸都判斷root的情況
 * 1. 如果root為空，就返回[null, null]
 * 2. 如果root的值小於等於target，就說明root及其左孩子的所有節點值都小於等於target，那麼就遞歸root.right,得到ans。將root.right指向ans[0],返回[root, ans[1]]
 * 3. 如果root的值大於target，就遞歸root.left。返回[ans[0], root]
 **/


// 自己的confuse
// 我不理解的是，理論上返回的是一個小的一個大的 
// 但為什麼遍歷右子樹之後要放在小的位置？？ans[0]？？不應該吧遞歸右子樹的部分放在ans[1]嗎？？？？

// root.right = ans[0];: 在此代码行中，ans[0] 代表了 root 右子树中所有小于等于 t 的节点组成的子树的根节点。将 root.right 更新为 ans[0] 是为了保留当前 root 节点为分割后仍符合小于等于 t 的最大子树的根节点。

// ans[0] = root;: 由于 root 节点的值小于等于 t，因此更新 ans[0] 为 root，意味着将当前节点 root 包括进小于等于 t 的子树中，即在当前的调用栈中，将 root 设置为返回的小于等于 t 的子树的新根节点。这一操作是因为任何大于当前 root 节点的值的节点都已经被分割到 ans[1] 中，所以当前 root 及其更新后的右子树（ans[0]）都属于小于等于 t 的一部分。
