// Medium
// DFS
// O(n)
// Similar: 364
// https://leetcode.cn/problems/nested-list-weight-sum/

import java.util.List;

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // 可以用dfs去找，如果這層遍歷到integer，就直接將integer乘以當前深度
        // 如果是列表，就繼續遞歸找，深度+1
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += dfs(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}
