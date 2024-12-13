// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/move-zeroes/

class Solution {
    // Use two pointers to move non-zero elements forward
    // `i` keeps track of the position to place the next non-zero element
    // `j` iterates through the array, moving non-zero values to position `i`
    // Fill remaining positions with zeros
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                if (i != j) {
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
