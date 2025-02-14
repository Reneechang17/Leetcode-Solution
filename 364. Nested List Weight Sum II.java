// Medium
// Stack, DFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/nested-list-weight-sum-ii/

import java.util.*;
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // First Pass: use DFS calculate the depth
        Stack<int[]> stack = new Stack<>();
        int maxDepth = dfs(nestedList, 1, stack);

        // Second Pass: calculate weighted sum use maxDepth-depth+1
        int res = 0;
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int val = cur[0], depth = cur[1];
            res += val * (maxDepth - depth + 1);
        }
        return res;
    }
    private int dfs(List<NestedInteger> nestedList, int depth, Stack<int[]> stack) {
        int maxDepth = depth;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                stack.push(new int[]{ni.getInteger(), depth});
            } else if (!ni.getList().isEmpty()) {
                maxDepth = Math.max(maxDepth, dfs(ni.getList(), depth + 1, stack));
            }
        }
        return maxDepth;
    }
}
