// Medium
// Stack, Array
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/132-pattern/

// Interesting.

// For this stack, we store the candidate which we are not sure if it is the biggest?
// If we meet the bigger one, then we pop(it would probably be mid) and compare.
// Simple words, mid is the mid candidate(2), stack store the possible (3) and if current
// is smaller then mid, which means we find the (1)

// Example: [3,1,4,2]
// Step1: process 2 -> stack:[2], mid:one
// Step2: process 4 -> stack:[2] pop -> mid = 2, stack:[4]
// Step3: process 1 -> 1 < mid(2) -> we find 1 < 2 < 4

import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return false;

        Stack<Integer> stack = new Stack<>();
        int mid = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < mid) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                mid = Math.max(mid, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
