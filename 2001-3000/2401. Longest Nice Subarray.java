// Medium
// Bit Manipulation, Sliding Window
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/longest-nice-subarray/

// What is AND = 0?
// two number have no 1 in same position
// ex. 5 = 0101, 8 = 1000 => nice
//     5 = 0101, 7 = 0111 => x

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, maxLen = 0, usedBit = 0;
        for (int right = 0; right < nums.length; right++) {
            while ((usedBit & nums[right]) != 0) {
                usedBit ^= nums[left]; // remove left bit
                left++;
            }

            usedBit |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
