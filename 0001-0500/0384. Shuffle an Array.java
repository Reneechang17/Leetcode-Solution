// Medium
// Fisher-Yates Algorithm
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/shuffle-an-array/

import java.util.Random;
class Solution {
    private int[] original;
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.nums = nums;
        this.random = new Random();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        for (int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}

// Fisher-Yates Shuffle随机洗牌算法：
// 从后向前遍历数组，对于每个元素i，生成一个范围从0-i的随机索引j，交换nums[i]和nums[j]
