// Easy
// Tree
// O(N)
// https://leetcode.com/problems/invert-binary-tree/

class Solution {
  public TreeNode invertTree(TreeNode root) {
      if (root == null) return null;

      invertTree(root.left);
      invertTree(root.right);
      swapNode(root);
      return root;
  }

  private void swapNode (TreeNode root) {
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
  }
}

/**
 * 反轉二叉樹：其實就是把樹的每一層的孩子做swap
 * 
 * 用DFS遍歷樹的每一層，把左右孩子交換即完成反轉
 * Note：BFS也可以操作，但是比較麻煩
 **/

 // BFS代碼

// class Solution {
//   public TreeNode invertTree(TreeNode root) {
//       if (root == null) {return null;}
//       ArrayDeque<TreeNode> deque = new ArrayDeque<>();
//       deque.offer(root);
//       while (!deque.isEmpty()) {
//           int size = deque.size();
//           while (size-- > 0) {
//               TreeNode node = deque.poll();
//               swap(node);
//               if (node.left != null) deque.offer(node.left);
//               if (node.right != null) deque.offer(node.right);
//           }
//       }
//       return root;
//   }

//   public void swap(TreeNode root) {
//       TreeNode temp = root.left;
//       root.left = root.right;
//       root.right = temp;
//   }
// }