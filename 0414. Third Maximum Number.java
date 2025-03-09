// Easy
// Counting
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/third-maximum-number/

class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            if (num == first || num == second || num == third) continue;
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
            count++;
        }
        return count >= 3 ? (int) third : (int) first;
    }
}
