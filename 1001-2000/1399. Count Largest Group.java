// Easy
// Math
// Time:O(n logM),Space:O(min(n, 36))
// https://leetcode.cn/problems/count-largest-group/

class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37]; // n最大为10^4，各位数字和最大是9*4=36，可以用数组
        int maxCnt = 0;

        for (int i = 1; i <= n; i++) {
            int digitSum = getDigitSum(i);
            count[digitSum]++;
            maxCnt = Math.max(maxCnt, count[digitSum]);
        }

        int res = 0;
        for (int i = 1; i <= 36; i++) {
            if (count[i] == maxCnt) {
                res++;
            }
        }
        return res;
    }

    private int getDigitSum(int x) {
        int sum = 0; 
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
