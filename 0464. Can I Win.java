// Medium
// Recursion, Memoization
// Time:O(2^n),Space:O(2^n)
// https://leetcode.cn/problems/can-i-win/

import java.util.*;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0)
            return true;
        // if all choosable num sum smaller than desired -> false
        if ((maxChoosableInteger * (maxChoosableInteger + 1)) / 2 < desiredTotal)
            return false;
        // map use as memo
        Map<Integer, Boolean> memo = new HashMap<>();
        // status start from 0, the target is desiredTotal, check if first player can win
        return canWin(0, desiredTotal, maxChoosableInteger, memo);
    }

    private boolean canWin(int state, int total, int maxChoosableInteger, Map<Integer, Boolean> memo) {
        if (total <= 0)
            return false;
        if (memo.containsKey(state))
            return memo.get(state);

        // try all available num
        for (int i = 0; i < maxChoosableInteger; i++) {
            // use bitmasking to represent and check if available(can choose)
            if (((state >> i) & 1) == 0) { // if i didn't select
                // select i + 1, update state and recursively check if other can win
                int nextState = state | (1 << i);
                // if other can't win, cur win
                if (!canWin(nextState, total - (i + 1), maxChoosableInteger, memo)) {
                    memo.put(state, true);
                    return true;
                }
            }
        }
        // if try all num but still cannot win, cur player will loss
        // keep the state and return false
        memo.put(state, false);
        return false;
    }
}

// 核心:通过递归检查每个玩家在每个状态下是否能赢，并使用位掩码来表示数字是否被选择，状态state是一个整数
//     其中每一位表示一个数字是否被选择。再透过记忆化搜索来存储每个状态的计算结果，避免重复计算。
