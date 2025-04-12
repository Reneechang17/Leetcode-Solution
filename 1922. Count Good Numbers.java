// Medium
// Math
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/count-good-numbers/

class Solution {
    private final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;
        long res = (modPow(5, evenPos) * modPow(4, oddPos) % MOD);

        return (int) res;
    }

    // 用快速幂，计算(base^exponent)%MOD
    private long modPow(long base, long exponent) {
        long res = 1;
        long mul = base;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                res = res * mul % MOD;
            }
            mul = mul * mul % MOD;
            exponent /= 2;
        }
        return res;
    }
}

/**
 * 组合：
 * 假设n=3，需要构造长度为3的好数字：
 * 第0位（偶数位）：可以是0,2,4,6,8中任选（5个）
 * 第1位（奇数位）：可以是2,3,5,7中任选（4个）
 * 第2位（偶数位）：可以是 0,2,4,6,8 中任选（5个）
 * 如果想知道总共有多少个这样的数字，就是把每个位置的可能性相乘：5×4×5=100个不同的好数字
 * => 5^(偶数位数量) * 4^(奇数位数量)
 * 
 * 计算偶数位和奇数位的数量：
 * 对于长度为n的数字：
 * 偶数位（第 0, 2, 4... 位）共有多少个？
 * - 如果n是奇数，有(n+1)/2个偶数位
 * - 如果n是偶数，有n/2个偶数位
 * 奇数位（第 1, 3, 5... 位）共有多少个？
 * - 如果n是奇数，有(n-1)/2个奇数位
 * - 如果n是偶数，有n/2个奇数位
 * => 偶数位的数量=Math.ceil(n/2)或Math.floor((n+1)/2)
 * 奇数位的数量=Math.floor(n/2)
 * 
 * 因为n非常大，循环次数太多会超时，可以用快速幂优化：
 * 快速幂是一种更高效计算a^b的方法。基本思想：
 * 如果b是偶数，a^b=(a^(b/2))^2
 * 如果b是奇数，a^b=a×(a^(b-1))
 * 可以将计算次数从b次减少到约log₂(b)次，提高效率
 */
