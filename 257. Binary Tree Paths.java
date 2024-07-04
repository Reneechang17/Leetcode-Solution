// Easy
// Tree, Backtracking
// O(N)
// https://leetcode.com/problems/binary-tree-paths/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
      List<String> res = new ArrayList<>();
      if (root == null) return res;

      List<Integer> paths = new ArrayList<>();
      traversal(root, paths, res);
      return res;
  }
  public void traversal(TreeNode root, List<Integer> paths, List<String> res) {
      paths.add(root.val);
      if (root.left == null && root.right == null) {
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < paths.size() - 1; i++) {
              sb.append(paths.get(i)).append("->");
          }
          sb.append(paths.get(paths.size() - 1));

          res.add(sb.toString());
          return;
      }
      if (root.left != null) {
          traversal(root.left, paths, res);
          paths.remove(paths.size() - 1); // backtracking
      }
      if (root.right != null) {
          traversal(root.right, paths, res);
          paths.remove(paths.size() - 1);
      }
  }
}

/**
 * 這題找二叉樹的所有路徑
 * 那麼就要從根節點一路遍歷到葉子節點，可以使用前序遍歷（中左右）
 * 另外，因為要把所有可能的路徑紀錄下來，需要用回溯來回進退找另一個路徑
 * 
 * 回溯：訪問完一個節點（包括他的所有子節點），需要返回到其父節點，以便訪問同一父節點的其他子節點
 * Note：遞歸查找和回溯要寫在一個花括號裡
 **/