// Easy
// Math
// Time:O(n^2), Space:O(1)
// https://leetcode.cn/problems/number-of-beautiful-pairs/

class Solution {
    public int countBeautifulPairs(int[] nums) {
        int cnt = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int firstDigit = getFirstDigit(nums[i]);
                int lastDigit = nums[j] % 10;

                if (checkGCD(firstDigit, lastDigit) == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int getFirstDigit(int x) {
        while (x >= 10) {
            x /= 10;
        }
        return x;
    }

    private int checkGCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
