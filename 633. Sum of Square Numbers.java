// Medium
// Two Pointers
// O(c^1/2)
// https://leetcode.cn/problems/sum-of-square-numbers/

class Solution {
    public boolean judgeSquareSum(int c) {
        // 給定一個非負整數c，檢查有沒有兩個整數ab，他們的平方和是c
        // 雙指針，一個指向0一個指向c的平方根，每一步計算其sum是否等於c
        long left = 0, right = (long)Math.sqrt(c); //  防止溢出

        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
