// Medium
// Matrix, Counting
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/convert-an-array-into-a-2d-array-with-conditions/

import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int[] cnt = new int[n + 1];

        for (int x : nums) {
            cnt[x]++;
        }

        for (int i = 1; i <= n; i++) {
            int x = cnt[i];
            for (int j = 0; j < x; j++) {
                if (res.size() <= j) {
                    res.add(new ArrayList<>());
                }
                res.get(j).add(i);
            }
        }
        return res;
    }
}
