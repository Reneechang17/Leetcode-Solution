// Medium
// DP
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/

class Solution {
    public int crackNumber(int ciphertext) {
        String str = String.valueOf(ciphertext);
        // c为当前解码方式的数量，b为前一个位置的解码方式，a为再前一个位置的解码方式
        int a = 0, b = 0, c = 1;

        for (int i = 0; i < str.length(); i++) {
            a = b;
            b = c;
            c = 0;
            c += b;
            if (i == 0)
                continue; // skip first char

            // 获取当前和前一个字符所组成的两位数，判断是否在10～25之间
            String prev = str.substring(i - 1, i + 1);
            if (prev.compareTo("25") <= 0 && prev.compareTo("10") >= 0) {
                c += a; // 如果是，则讲前前位置的解码数（a）加到当前（c）
            }
        }
        return c;
    }
}
/**
 * 和leetcode91的区别：这题的解码方式是有前两项的解码方式数决定，所以类似爬梯子问题，需要三个变量记录前一个字符和前两个字符的**组合**
 * Leetcode91每个位置的解码方式数由前一个位置的解码方式和当前数字与前两个数字的组合数决定
 */
