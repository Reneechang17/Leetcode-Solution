// Medium
// Serialize, Hash Table
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/find-duplicate-subtrees/

import java.util.*;

class Solution {
  // Use post-order traversal to serialize each subtree
  // Serialize a subtree as "left,right,value" to uniquely represent its structure and values
  // Use map to track the freq of each serialized subtree, if the freq becomes 2, add it to res
  // Null nodes are serialized as "#"

  // map to store each subtree's serialized and its freq
  Map<String, Integer> map = new HashMap<>();
  List<TreeNode> res = new ArrayList<>();

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      postOrder(root);
      return res;
  }
  private String postOrder(TreeNode node) {
      if (node == null) {
          return "#";
      }

      String left = postOrder(node.left);
      String right = postOrder(node.right);
      String subtree = left + "," + right + "," + node.val;

      // update the freq of serialized subtree
      map.put(subtree, map.getOrDefault(subtree, 0) + 1);

      // check if the subtree appear more than once
      if (map.get(subtree) == 2) {
          res.add(node);
      }
      return subtree;
  }
}
