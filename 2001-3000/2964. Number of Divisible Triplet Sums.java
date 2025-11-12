// Medium
// Math
// Time:O(n^2), Space:O(1)
// https://leetcode.cn/problems/number-of-divisible-triplet-sums/

// Emmm... we could fix first two and find the third one so that the complexity 
// would looks better (O(n^3) -> O(n^2))

class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        int n = nums.length, cnt = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int twosum = (nums[i] + nums[j]) % d;
                int need = (d - twosum) % d;

                for (int k = j + 1; k < n; k++) {
                    if (nums[k] % d == need)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
