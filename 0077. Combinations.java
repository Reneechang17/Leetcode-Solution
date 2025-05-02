// Medium
// Backtracking
// Time:O(C(n,k)), Space:O(k)
// https://leetcode.cn/problems/combinations/

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1); // start from 1
        return res;
    }

    private void backtracking(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
