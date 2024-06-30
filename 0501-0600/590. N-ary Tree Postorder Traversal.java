// Easy
// Tree
// O(n)
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> postorder(Node root) {
      List<Integer> result = new ArrayList<>();
      if(root == null) return result;

      postorderTraversal(root, result);
      return result;
  }

  public void postorderTraversal(Node node, List<Integer> result){
      if(node == null) return;

      for(Node child : node.children){
          postorderTraversal(child, result);
      }

      result.add(node.val);
  }
}

// 這題注意的是傳進來的是Node