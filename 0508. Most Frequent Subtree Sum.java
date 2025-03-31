// Medium
// DFS, Map
// Time:O(n),Space:O(n)
// https://leetcode.com/problems/most-frequent-subtree-sum/

import java.util.*;

class Solution {
    // DFS to traverse the tree and Map record the freq of each subtree sum

    private Map<Integer, Integer> map = new HashMap<>();
    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> list = new ArrayList<>();
        for (int sum : map.keySet()) {
            if (map.get(sum) == maxFreq) {
                list.add(sum);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = dfs(node.left), rightSum = dfs(node.right);
        int sum = node.val + leftSum + rightSum;
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxFreq = Math.max(maxFreq, map.get(sum));

        return sum;
    }
}
