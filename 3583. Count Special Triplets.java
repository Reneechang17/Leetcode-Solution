import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        long res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        Map<Integer, Integer> left = new HashMap<>();

        for (int j = 0; j < n; j++) {
            int target = nums[j] * 2;

            int right = map.getOrDefault(target, 0) -
                    left.getOrDefault(target, 0);

            if (nums[j] == target)
                right--;

            int leftT = left.getOrDefault(target, 0);

            res = (res + (long) leftT * right) % MOD;

            left.put(nums[j], left.getOrDefault(nums[j], 0) + 1);
        }
        return (int) res;
    }
}
