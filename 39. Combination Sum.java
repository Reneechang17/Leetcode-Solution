// Medium
// Backtracking
// O(2^n)
// Similar: 77
// https://leetcode.cn/problems/combination-sum/

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        backtracking(res, path, candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, LinkedList<Integer> path, int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            // 回溯傳入的還是當前的i因為這個數字可以重複使用
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.removeLast();
        }
    }
}

/**
 * 組合總和問題
 * 給定一個無重複元素的數組和一個目標數，找出candidates中可以使數字和為目標的所有不同組合，並以列表形式返回
 * 可以按任意順序返回這些組合。數組中的同一個數字可以無限制重複被選取，至少有一個數字的被選取數量不同，則兩種組合是不同的
 * 
 * 思路：排序+回溯+剪枝
 * 
 * 剪枝：當sum+candidates[i]大於target時直接break
 **/