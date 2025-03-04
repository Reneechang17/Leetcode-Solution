// Hard
// DP, Binary Search
// Time:O(k*n*logn),Space:O(k*n)
// https://leetcode.cn/problems/super-egg-drop/

import java.util.*;

class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (!memo.containsKey(n * 100 + k)) {
            int res;
            if (n == 0) {
                res = 0;
            } else if (k == 1) {
                res = n;
            } else {
                int low = 1, high = n;
                while (low + 1 < high) {
                    int x = (low + high) / 2;
                    int t1 = dp(k - 1, x - 1);
                    int t2 = dp(k, n - x);

                    if (t1 < t2) {
                        low = x;
                    } else if (t1 > t2) {
                        high = x;
                    } else {
                        low = high = x;
                    }
                }
                res = 1 + Math.min(Math.max(dp(k - 1, low - 1), dp(k, n - low)), Math.max(dp(k - 1, high - 1), dp(k, n - high)));
            }
            memo.put(n * 100 + k, res);
        }
        return memo.get(n * 100 + k);
    }
}

/**
给定k个蛋和n层楼，最坏情况下需要确定楼的最低破蛋层，并且最少的操作次数
每次丢蛋都会有两种结果：破了 or 没破
如果蛋破了：从1～x-1层中继续找（此时有k-1个蛋）
如果蛋没破：从x+1～n层继续找（此时仍有k个蛋）
以上部分可以用二分优化

=> 定义dp数组：表示用k个蛋和n层楼，最少需要几次丢蛋才能确定破蛋的最小楼层
状态转移：蛋破了=>变成k-1个蛋和x-1层楼的问题，蛋没破=>变成k个蛋和n-x层楼的问题
 */
