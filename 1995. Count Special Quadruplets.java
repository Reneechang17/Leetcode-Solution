// Easy
// https://leetcode.cn/problems/count-special-quadruplets/

import java.util.*;

class Solution {
    // Brute Force
    // Time:O(n^4), Space:O(1)
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}

class Solution2 {
    // HashMap
    // Time:O(n^3), Space:O(min(n,C))
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int c = n - 2; c >= 2; c--) {
            map.put(nums[c + 1], map.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += map.getOrDefault(nums[a] + nums[b] + nums[c], 0);
                }
            }
        }
        return ans;
    }
}
