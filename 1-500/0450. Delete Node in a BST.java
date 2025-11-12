// Medium
// Tree
// O(logn)
// https://leetcode.com/problems/delete-node-in-a-bst/

class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
      // basecase：根结点为空
      if (root == null) return root;

      // 如果找到要删除的节点
      if (root.val == key) {
          if (root.left == null) {
              return root.right;
          } else if (root.right == null) {
              return root.left;
              // 该节点同时有左右子树
          } else {
              // 要找右子树的最小值（往最左边一直找）
              TreeNode cur = root.right;
              while (cur.left != null) {
                  cur = cur.left;
              }
              // 把要删除节点的左子树接到右子树的最小节点的左边
              cur.left = root.left;
              // 右子树提升为新节点
              root = root.right;
              return root;
          }
      }
      if (root.val > key) root.left = deleteNode(root.left, key);
      if (root.val < key) root.right = deleteNode(root.right, key);
      return root;
  }
}

/**
 * 刪除二叉搜索樹中的節點
 * 
 * 有幾種需要考慮的情況：
 * 1. 沒找到
 * 2. 找到且他的左右孩子都是空，直接刪除
 * 3. 找到了，左孩子為空，右孩子不為空，刪除後右孩子補位，返回右孩子為根節點
 * 4. 找到了，左孩子不為空，右孩子為空，刪除後左孩子補位，返回左孩子為根節點
 * 5. 找到了，左右孩子都不為空，需要將刪除節點的左孩子放到右子樹的最左邊的節點的左孩子上（因為二叉搜索樹的特性）
 * 返回刪除節點的右孩子為新的節點
 * 
 * 尋找key的方向也根據二叉搜索樹的特性，和key比較大小確定往左邊還是往右邊搜索
 **/