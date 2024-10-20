// Medium
// Backtracking
// O(2^n)
// Similar: 77
// https://leetcode.cn/problems/combination-sum/

import java.util.*;

class Solution {
    // 組合總和問題：candidates中的數字可以無限重複選擇 -> 回溯
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(res, path, candidates, target, 0, 0); // 0 are sum and start
        return res;
    }

    void backtracking(List<List<Integer>> res, LinkedList<Integer> path, int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            // 回溯傳入的還是當前i，因為這個數字可以重複使用
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.removeLast();
        }
    }
}
