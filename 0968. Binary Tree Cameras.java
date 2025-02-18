// Hard
// Tree, Greedy
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/binary-tree-cameras/

class Solution {
  // 0:uncovered, 1:camera, 2:covered
  // Greedy: try to put cam on leaf nodes
  int count = 0;
  public int minCameraCover(TreeNode root) {
      if (minCam(root) == 0) count++;
      return count;
  }

  private int minCam(TreeNode root) {
      if (root == null) return 2; // seem null node as covered
      int left = minCam(root.left);
      int right = minCam(root.right);

      // if left and right are covered(no cam), cur -> 0
      if (left == 2 && right == 2) return 0;

      // if either left or right not covered, cur -> 1, count++
      if (left == 0 || right == 0) {
          count++;
          return 1;
      }

      // if either left or right has one cam, cur -> 2 
      return 2;
  }
}
