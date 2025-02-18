// Easy
// Tree
// Time:O(n), Space:O(n)->worse case:a skewed tree, O(logn)->balanced tree
// https://leetcode.cn/problems/invert-binary-tree/

import java.util.ArrayDeque;
class Solution {
  public TreeNode invertTree(TreeNode root) {
      if (root == null) return null;
      invertTree(root.left);
      invertTree(root.right);
      swap(root);
      return root;
  }
  private void swap(TreeNode root) {
      TreeNode tmp = root.left;
      root.left = root.right;
      root.right = tmp;
  }
}

// initial: root = 4
// 1. vis left subtree: root = 2 -> vis left subtree: root = 1 -> left & right = null -> return node 1
//    vis right subtree: root = 3 -> left & right = null -> return node 3
//  => swap at root 2: swap root.left and root.right -> [2, 3, 1]
// 2. vis right subtree: root = 7 -> vis left subtree: root = 6 -> left & right = null -> return node 6
//    vis right subtree: root = 9 -> left & right = null -> return node 9
//  => swap at root 7: swap root.left and root.right -> [7, 9, 6] 
// 3. swap at root 4: swap root.left and root.right -> [4,7,2,9,6,3,1]

// BFS Solution
class Solution2 {
  public TreeNode invertTree(TreeNode root) {
      if (root == null) {return null;}
      ArrayDeque<TreeNode> deque = new ArrayDeque<>();
      deque.offer(root);
      while (!deque.isEmpty()) {
          int size = deque.size();
          while (size-- > 0) {
              TreeNode node = deque.poll();
              swap(node);
              if (node.left != null) deque.offer(node.left);
              if (node.right != null) deque.offer(node.right);
          }
      }
      return root;
  }

  public void swap(TreeNode root) {
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
  }
}
