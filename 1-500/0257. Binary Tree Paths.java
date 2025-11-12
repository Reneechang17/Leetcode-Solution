// Easy
// Tree, Backtracking
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/binary-tree-paths/

import java.util.*;
class Solution {
    // Use backtracking to find all possible paths 
    // And use StringBuilder to build the path
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> path = new ArrayList<>();
        backtracking(root, path, res);
        return res;
    }
    private void backtracking(TreeNode root, List<Integer> path, List<String> res) {
        path.add(root.val);
        // Once reach the leaf node, build the path and add to sb
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            backtracking(root.left, path, res);
            path.remove(path.size() - 1); // backtracking
        }
        if (root.right != null) {
            backtracking(root.right, path, res);
            path.remove(path.size() - 1); // backtracking
        }
    }
}
