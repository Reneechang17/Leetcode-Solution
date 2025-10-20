// Medium
// DFS, Map
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/path-sum-iv/

// The challenge thing for this question is find the path....:)
// Can use Map to store DP -> V, leftSub is (D+1)*10 + P*2-1, rightSub is (D+1)*10 + P*2.
// And use DFS to recursively calculate the path, and return the total once reached leaf.

import java.util.*;

class Solution {
    public int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int k = x / 10; // Depth+Position
            int v = x % 10;
            map.put(k, v);
        }

        return dfs(map, nums[0] / 10, 0);
    }
    
    private int dfs(Map<Integer, Integer> map, int node, int sum) {
        int depth = node / 10, pos = node % 10;

        int leftSub = (depth + 1) * 10 + pos * 2 - 1;
        int rightSub = (depth + 1) * 10 + pos * 2;

        int curSum = sum + map.get(node);

        // If we reached leaf, return the sum we running.
        if (!map.containsKey(leftSub) && !map.containsKey(rightSub)) {
            return curSum;
        }

        // If not reached, recursively calling dfs.
        int total = 0;
        if (map.containsKey(leftSub)) {
            total += dfs(map, leftSub, curSum);
        }

        if (map.containsKey(rightSub)) {
            total += dfs(map, rightSub, curSum);
        }

        return total;
    }
}
