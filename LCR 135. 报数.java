// Easy
// Math
// Time:O(10^cnt),Space:O(1)
// https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/

class Solution {
    public int[] countNumbers(int cnt) {
        int end = (int)Math.pow(10, cnt) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
