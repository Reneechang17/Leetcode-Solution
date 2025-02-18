// Medium
// BST, Recursion
// O(4^n / n^1/2)
// https://leetcode.com/problems/unique-binary-search-trees-ii/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<TreeNode> generateTrees(int n) {
      if (n == 0) return new ArrayList<TreeNode>();
      return generate(1, n);
  }

  private List<TreeNode> generate(int start, int end) {
      List<TreeNode> allTrees = new ArrayList<>();
      if (start > end) {
          allTrees.add(null); // 如果當前子樹不合法，添加一個null
          return allTrees;
      }

      for (int i = start; i <= end; i++) {
          // 用[start, i - 1]構建左子樹
          List<TreeNode> left = generate(start, i - 1);
          // [i + 1, end]構建右子樹
          List<TreeNode> right = generate(i + 1, end);

          // 從左子樹和右子樹的集合中選取每一種組合與根節點拼接
          for (TreeNode l : left) {
              for (TreeNode r : right) {
                  TreeNode cur = new TreeNode(i);
                  cur.left = l;
                  cur.right = r;
                  allTrees.add(cur);
              }
          }
      }
      return allTrees;
  }
}

/**
 * 要求生成所有由1到n為節點的唯一BST
 * 
 * 這題可以用遞歸來做，對於任意一個數i，如果用i作為根節點
 * 1～i-1構成左子樹，i+1～n構成右子樹 => 遞歸方法需要傳入start和end
 * 每次遞歸時，如果start、end已經不合法（start > end)，則添加null
 **/