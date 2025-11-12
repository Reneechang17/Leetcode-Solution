// Easy
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/find-n-unique-integers-sum-up-to-zero/

class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        int left = 0, right = n - 1;
        int value = 1;

        while (left < right) {
            res[left] = value;
            res[right] = -value;
            left++;
            right--;
            value++;
        }
        return res;
    }
}
