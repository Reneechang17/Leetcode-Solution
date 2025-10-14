// Medium
// Prefix
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/number-of-sub-arrays-with-odd-sum/

// how can we form odd?
// even+odd=odd, odd+even=odd, even+even=even, odd+odd=even

class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long res = 0;
        int oddCount = 0, evenCount = 1, sum = 0;

        for (int x : arr) {
            sum += x;
            if (sum % 2 == 0) {
                res = (res + oddCount) % MOD;
                evenCount++;
            } else {
                res = (res + evenCount) % MOD;
                oddCount++;
            }
        }
        return (int) res;
    }
}
