// Hard
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/find-the-number-of-subarrays-where-boundary-elements-are-maximum/
// 可以看灵茶山艾府的题解，很清楚为什么用单调栈

import java.util.Stack;

class Solution {
    // 单调栈（底大顶小）
    public long numberOfSubarrays(int[] nums) {
        // 每个元素本身就是一个valid的subarray
        long ans = nums.length;
        // [元素, 出现次数]
        Stack<int[]> stack = new Stack<>();
        // 初始化：给一个无穷值
        stack.push(new int[]{Integer.MAX_VALUE, 0});

        for (int num : nums) {
            while (num > stack.peek()[0]) {
                stack.pop();
            }
            if (num == stack.peek()[0]) {
                ans += stack.peek()[1];
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{num, 1});
            }
        }
        return ans;
    }
}
