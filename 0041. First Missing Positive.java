// Hard
// Hash Table(原地哈希)
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/first-missing-positive/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // swap nums[i] and nums[nums[i] - 1]
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        // if all pos are correct, the missing num will be n+1
        return n + 1;
    }
}

// 要求正整数 -> 可以忽略所有不[1,n]范围内的数字
// 可以利用数组下标来记录数字存在情况，把每个数字x放入下标x-1处，类似桶排序
// 如果当前数组x在数组内并满足1<=x<=x，把x放到nums[x-1]的位置
// 最后遍历数组nums，如果下标i处没有存放i+1，那么i+1就是第一个缺失的正整数
