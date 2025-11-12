// Easy
// Array, Counter
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/maximum-number-of-pairs-in-array/

class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] arr = new int[101];
        for (int x : nums) {
            arr[x]++;
        }
        int res = 0, remain = 0;
        for (int x : arr) {
            res += x / 2;
            remain += x % 2;
        }
        return new int[]{res, remain};
    }
}
