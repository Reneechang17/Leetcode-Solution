// Easy
// String, Counting
// Time:O((high - low) * log(high)),Space:O(log(high))
// https://leetcode.cn/problems/count-symmetric-integers/

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for (int num = low; num <= high; num++) {
            if (helper(num)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean helper(int num) {
        String numStr = Integer.toString(num);
        int len = numStr.length();
        if (len % 2 != 0) return false;

        int half = len / 2, firstHalf = 0, secHalf = 0;
        for (int i = 0; i < half; i++) {
            firstHalf += numStr.charAt(i) - '0';
        }
        for (int i = half; i < len; i++) {
            secHalf += numStr.charAt(i) - '0';
        }
        
        return firstHalf == secHalf;
    }
}
