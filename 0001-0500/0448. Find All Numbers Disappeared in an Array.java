// Easy
// Array
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n + 1]; // 1-index arr
        for (int x : nums) {
            cnt[x]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0)
                res.add(i);
        }
        return res;
    }
}
