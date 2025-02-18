// Hard
// Tree, DFS
// O(n)
// https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/

import java.util.*;

class Solution {
  
  // 序列化：將二叉樹序列化成字符串
  // 用前序遍歷，將節點值和null分別保存在字符串中
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
      // root -> left -> right
      StringBuilder sb = new StringBuilder();
      preorder(root, sb);
      return sb.toString();
  }

  private void preorder(TreeNode root, StringBuilder sb) {
      if (root == null) {
          sb.append("null").append(",");
      } else {
          sb.append(root.val).append(",");
          preorder(root.left, sb);
          preorder(root.right, sb);
      }
  }

  // 反序列化：將字符串反序列化成二叉樹
  // 遞歸重建，每次取出一個節點，如果是null則返回null
  // 如果存在，則遞歸重建左右子樹
  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
      String[] nodes = data.split(",");
      LinkedList<String> list = new LinkedList<>(Arrays.asList(nodes));
      return helper(list);
  }

  private TreeNode helper(LinkedList<String> list) {
      if (list.isEmpty()) return null;

      String val = list.poll();
      if (val.equals("null")) {
          return null;
      }

      TreeNode node = new TreeNode(Integer.parseInt(val));
      node.left = helper(list);
      node.right = helper(list);

      return node;
  }
}
