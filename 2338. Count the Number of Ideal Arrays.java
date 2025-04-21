// Hard
// Math
// Time:O((n+ω(m))⋅ω(m)+mω(m)),Space:O((n+log(m))⋅log(m))
// https://leetcode.cn/problems/count-the-number-of-ideal-arrays/


import java.util.*;

class Solution {
    static int MOD = 1000000007;
    static int MAX_N = 10010;
    static int MAX_P = 15; // 最多有15个质因子
    static int[][] c = new int[MAX_N + MAX_P][MAX_P + 1];
    static int[] sieve = new int[MAX_N]; // 最小质因子
    static List<Integer>[] ps = new List[MAX_N]; // 质因子个数列表

    public Solution() {
        if (c[0][0] == 1) {
            return;
        }

        for (int i = 0; i < MAX_N; i++) {
            ps[i] = new ArrayList<>();
        }

        for (int i = 2; i < MAX_N; i++) {
            if (sieve[i] == 0) {
                for (int j = i; j < MAX_N; j += i) {
                    if (sieve[j] == 0) {
                        sieve[j] = i;
                    }
                }
            }
        }

        for (int i = 2; i < MAX_N; i++) {
            int x = i;
            while (x > 1) {
                int p = sieve[x], cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                ps[i].add(cnt);
            }
        }

        c[0][0] = 1;
        for (int i = 1; i < MAX_N + MAX_P; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MAX_P); j++) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        long ans = 0;
        for (int x = 1; x <= maxValue; x++) {
            long mul = 1;
            for (int p : ps[x]) {
                mul = mul * c[n + p - 1][p] % MOD;
            }
            ans = (ans + mul) % MOD;
        }
        return (int)ans;
    }
}

// 题解：https://leetcode.cn/problems/count-the-number-of-ideal-arrays/solutions/3650511/tong-ji-li-xiang-shu-zu-de-shu-mu-by-lee-usvr/?envType=daily-question&envId=2025-04-22
