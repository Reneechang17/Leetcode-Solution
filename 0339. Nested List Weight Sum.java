// Medium
// DFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/nested-list-weight-sum/

import java.util.List;
class Solution {
    // Use DFS to traverse the nested list, if occur an Integer,
    // add integer * depth to res; if occur a list, recursively call 
    // DFS with depth + 1
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    private int dfs(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                res += ni.getInteger() * depth;
            } else {
                res += dfs(ni.getList(), depth + 1);
            }
        }
        return res;
    }
}
