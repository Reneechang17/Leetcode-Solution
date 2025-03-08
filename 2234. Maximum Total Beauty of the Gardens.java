// Hard
// Greedy, Two Pointers
// Time:O(nlogn),Space:O(logn)
// https://leetcode.cn/problems/maximum-total-beauty-of-the-gardens/

import java.util.Arrays;

class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
        // 花园的花朵数不超过target
        for (int i = 0; i < n; i++) {
            flowers[i] = Math.min(flowers[i], target);
        }
        Arrays.sort(flowers);
        // 将数组反转 -> 花朵数最大化
        reverse(flowers);

        // 计算花朵总数
        long sum = 0;
        for (int f : flowers) {
            sum += f;
        }

        // 如果新花朵可以让所有花园都达到full状态，直接返回美丽度
        long ans = 0;
        if ((long) target * n - sum <= newFlowers) {
            ans = (long) full * n;
        }

        long pre = 0;
        int ptr = 0;
        // 遍历每个花园，计算不同情况下的美丽度
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                pre += flowers[i - 1];
            }
            // 如果当前花园完整，skip
            if (flowers[i] == target) continue;

            // 计算剩余花朵数
            long rest = newFlowers - ((long)target * i - pre);
            if (rest < 0) break;

            // 将剩余花朵分配到不完整花园
            while (!(ptr >= i && (long)flowers[ptr] * (n - ptr) - sum <= rest)) {
                sum -= flowers[ptr];
                ptr++;
            }

            // 计算最小花朵数贡献
            rest -= (long) flowers[ptr] * (n - ptr) - sum;
            ans = Math.max(ans, (long)full * i + (long)partial * Math.min(flowers[ptr] + rest / (n - ptr), (long)target - 1));
        }
        return ans;
    }
    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
