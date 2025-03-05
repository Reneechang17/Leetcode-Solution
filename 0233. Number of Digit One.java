// Hard
// Math, Counter
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/number-of-digit-one/

class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long factor = 1; // represent the cur digit's place(1, 10, 100....)

        while (factor <= n) {
            long lower = n - (n / factor) * factor; // num on right of cur digit
            long cur = (n / factor) % 10;
            long higher = n / (factor * 10); // num on left of cur digit

            // calculate the count of 1's contributed by cur digit
            if (cur == 0) {
                // if cur digit is 0, no '1's contributed to res
                count += higher * factor;
            } else if (cur == 1) {
                // if cur digit is 1, count the cur part and the lower part
                count += higher * factor + lower + 1;
            } else {
                // if cur digit is greater than 1, count all lower parts
                count += (higher + 1) * factor;
            }
            factor *= 10; // move to next digit
        }
        return count;
    }
}

/**
 * 考虑数字n的每一位数字对结果的贡献，从低位到高位逐位分析，计算每一位上1出现的次数。
 * 对于每一位，可以将数字分成三个部分：
 * 1. 高位数字：当前位以上的数字
 * 2. 当前位数字
 * 3. 地位数字：当前位以下的数字
 */
