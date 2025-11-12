// Medium
// Backtracking, HashSet
// Time:O(C(n,numSelect)*m*n)~O(2ⁿ*m),Space:O(n)
// https://leetcode.cn/problems/maximum-rows-covered-by-columns/

import java.util.*;

class Solution {
    // Brute Force to search all numSelect columns(up to C(n, numSelect))subsets
    // Check how many rows can covered by each subset
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length, maxRows = 0;
        List<Integer> cols = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            cols.add(j); // add all cols to list
        }

        for (List<Integer> s : combinations(cols, numSelect)) {
            Set<Integer> set = new HashSet<>(s);
            int cnt = 0;

            for (int i = 0; i < m; i++) {
                boolean covered = true;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1 && !set.contains(j)) {
                        covered = false;
                        break;
                    }
                }
                if (covered)
                    cnt++;
            }
            maxRows = Math.max(maxRows, cnt);
        }
        return maxRows;
    }
    
    private List<List<Integer>> combinations(List<Integer> nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums, k, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> tmp, List<Integer> nums, int k, int start) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            tmp.add(nums.get(i));
            backtracking(res, tmp, nums, k, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
