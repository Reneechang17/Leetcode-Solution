// Medium
// Tree, BFS, backtracking
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/path-sum-iii/

// Can optimized with PrefixSum, to check any path's sum.
// If there are two prefixSum their diff is 5, which means the middle part of them are 5.

import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSum);
    }

    private int dfs(TreeNode node, long cur, int target, Map<Long, Integer> map) {
        if (node == null)
            return 0;
        
        cur += node.val;
        int cnt = map.getOrDefault(cur - target, 0);

        map.put(cur, map.getOrDefault(cur, 0) + 1);
        cnt += dfs(node.left, cur, target, map);
        cnt += dfs(node.right, cur, target, map);
        map.put(cur, map.get(cur) - 1); // backtracking
        
        return cnt;
    }
}
