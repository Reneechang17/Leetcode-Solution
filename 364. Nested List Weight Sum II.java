// Medium
// Stack
// O(n)
// Similar: 339
// https://leetcode.cn/problems/nested-list-weight-sum-ii/

import java.util.*;

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // 相似：339，越深權重越大 -> DFS
        // 這題由於權重是反向的，並且也不知道列表的深度，DFS難以實現 -> 棧
        Stack<int[]> stack = new Stack<>();
        // 可以用一个方法來找最大深度，如果找到就紀錄他的值和深度
        int maxDepth = getDepth(nestedList, 1, stack);

        int sum = 0;
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int val = cur[0];
            int depth = cur[1];
            sum += val * (maxDepth - depth + 1);
        }
        return sum;
    }

    private int getDepth(List<NestedInteger> nestedList, int depth, Stack<int[]> stack) {
        int maxDepth = depth;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                stack.push(new int[]{ni.getInteger(), depth});
            } else if (!ni.getList().isEmpty()) {
                maxDepth = Math.max(maxDepth, getDepth(ni.getList(), depth + 1, stack));
            }
        }
        return maxDepth;
    }
}

/**
 * 嵌套列表加權和II：嵌套列表的每個整數都要乘以其深度的倒數，而深度的計算方式是最底層為1，向上逐層遞增
 * 也就是深度越深，權重越小
 * 這題可以做兩次遍歷：第一次遍歷先計算最大深度，第二次遍歷使用到的最大深度來計算加權和，加權公式為：(maxDepth - depth + 1) * value
 **/
