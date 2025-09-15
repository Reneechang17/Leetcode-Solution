// Medium
// Two Pointers, Math
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/sort-transformed-array/

class Solution {
    // a decide we fill from tail or head
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int idx = a >= 0 ? nums.length - 1 : 0;

        while (left <= right) {
            int l = calc(nums[left], a, b, c);
            int r = calc(nums[right], a, b, c);

            if (a >= 0) {
                // choose the bigger one
                if (l >= r) {
                    res[idx] = l;
                    left++;
                } else {
                    res[idx] = r;
                    right--;
                }
                idx--;
            } else {
                // choose the smaller one
                if (l <= r) {
                    res[idx] = l;
                    left++;
                } else {
                    res[idx] = r;
                    right--;
                }
                idx++;
            }
        }
        return res;
    }

    private int calc(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
