// Medium
// Greedy
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/maximum-swap/

class Solution {
    public int maximumSwap(int num) {
        String nums = Integer.toString(num);
        char[] digit = nums.toCharArray();
        int n = digit.length;

        // store last index of each digit(0-9)
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[digit[i] - '0'] = i;
        }

        for (int i = 0; i < n; i++) {
            // check if a larger digit exists to the right of cur digit
            for (int d = 9; d > digit[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = digit[i];
                    digit[i] = digit[last[d]];
                    digit[last[d]] = tmp;
                    return Integer.parseInt(new String(digit));
                }
            }
        }
        return num; // if no swap
    }
}
