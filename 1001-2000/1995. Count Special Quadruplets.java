// Easy
// Map
// Time:O(n^3), Space:O(n^2)
// https://leetcode.cn/problems/count-special-quadruplets/

import java.util.*;

// It's pretty simple to come up with brute force but the complexity is beautiful as well.
// emmm the optimize way looks a bit funny just give O(n^4)->O(n^3) with hashmap,
// we could see nums[a]+nums[b] = nums[d]-nums[c]........

class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                int diff = nums[d] - nums[b + 1]; // nums[d] - nums[c]
                map.put(diff, map.getOrDefault(diff, 0) + 1);
            }

            for (int a = 0; a < b; a++) {
                int sum = nums[a] + nums[b];
                cnt += map.getOrDefault(sum, 0);
            }
        }
        return cnt;
    }
}
