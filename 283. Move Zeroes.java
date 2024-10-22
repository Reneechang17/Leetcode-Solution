// Easy
// Two Pointers
// O(n)
// https://leetcode.cn/problems/move-zeroes/

class Solution {
    // goal: 把所有0挪到數組最後，並且保持非零元素的相對順序
    // 不能用copy -> Two pointers: 用一個指針填充非零元素，剩下的位置補0
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
