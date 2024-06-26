// Easy
// Tree
// O(n)
// https://leetcode.com/problems/n-ary-tree-preorder-traversal/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> preorder(Node root) {
      List<Integer> res = new ArrayList<>();
      preorder (root, res);
      return res;
  }

  private void preorder (Node node, List<Integer> res) {
      if (node == null) return;

      res.add(node.val);
      for (Node child : node.children) {
          preorder(child, res);
      }
  }
}

// 這題注意的是傳進來的是Node