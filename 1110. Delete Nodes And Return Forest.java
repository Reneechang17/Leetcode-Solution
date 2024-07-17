// Medium
// Array, DFS, Hash Table
// O(N)
// https://leetcode.com/problems/delete-nodes-and-return-forest/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
      Set<Integer> deleteSet = new HashSet<>();
      for (int num : to_delete) {
          deleteSet.add(num);
      }
      List<TreeNode> res = new ArrayList<>();
      TreeNode newRoot = delNodesRecursive(root, deleteSet, res);
      if (newRoot != null) {
          res.add(newRoot);
      }
      return res;
  }
  private TreeNode delNodesRecursive(TreeNode node, Set<Integer> deleteSet, List<TreeNode> res) {
      if (node == null) return null;
      
      node.left = delNodesRecursive(node.left, deleteSet, res);
      node.right = delNodesRecursive(node.right, deleteSet, res);

      if (deleteSet.contains(node.val)) {
          if (node.left != null) res.add(node.left);
          if (node.right != null) res.add(node.right);
          return null;
      }
      return node;
  }
}

/**
 * 給定一個二叉樹和一個要刪除的節點的數組，要從二叉樹中刪除一些指定的節點，並且返回剩下的每一片獨立的子樹
 * 每當一個節點被刪除，他的子節點就會和原本的父節點斷開連接，變成新的樹的根節點
 * 
 * 思路：
 * 可以把要刪除的節點都放在一個set裡，方便之後快速查看任何一個節點是否需要刪除
 * 用DFS遞歸樹（後序遍歷），先處理子節點，再處理他們的父節點
 * 
 * 判斷：
 * 如果當前節點需要被刪除：我們可以看他的子節點。如果子節點存在且不需要刪除，那麼這些子節點就會變成新的樹的根節點，把他添加到res中，然後返回null，表示這個節點已經被刪除
 * 如果當前節點不需要被刪除：只需要更新這個節點的左右子節點的連接，確保他們正確指向那些沒有被刪除的節點
 **/