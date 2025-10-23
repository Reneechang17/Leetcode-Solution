// Medium
// DFS, backtracking
// Time:O(n^2), Space:O(n) 
// https://leetcode.cn/problems/path-sum-ii/

import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, res);
        return res;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> res) {
        if (node == null)
            return;
        
        path.add(node.val);
        target -= node.val;

        // check if reach leaf first and target = 0 -> collect to res
        if (node.left == null && node.right == null && target == 0) {
            res.add(new ArrayList<>(path));
        }

        dfs(node.left, target, path, res);
        dfs(node.right, target, path, res);

        path.remove(path.size() - 1);
    }
}
