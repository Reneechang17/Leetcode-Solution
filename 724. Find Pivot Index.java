// Easy
// Prefix Sum
// O(n)
// https://leetcode.cn/problems/find-pivot-index/

class Solution {
    // 找一個中心索引，它的左邊元素的和等於右邊元素的和，如果有多個有效的i，返回最左邊的
    // 在計算它的左右兩側的時候，nums[i]是不計算進去的 -> 可以用前綴和來檢查，目標是找出leftSum == rightSum
    // rightSum = totalSum - leftSum - nums[i]
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i]; // 不滿足就把當前nums[i]加到leftSum上，計算下一個
        }
        return -1;
    }
}
