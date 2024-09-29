// Easy
// Hash Table, Math
// O(logn)
// https://leetcode.cn/problems/happy-number/

import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        // 需要注意如果遇到重複的數組，會陷入循環，所以要對遇到的數字去重
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int res = 0;
            while (n > 0) {
                int digit = n % 10;
                res += digit * digit;
                n /= 10;
            }
            n = res;
        }
        return n == 1;
    }
}

/**
 * 思路：
 * 用hashset來紀錄和出現的次數，用set更利於去重
 * 外層循環處理每一次得出的n，條件為：當n還不等於1，以及n不在哈希表中時（如果出現過，會無限循環）
 * 內層循環處理具體每一位數平方相乘，條件為：當n大於0時，先將n%10找個位數，再將其相乘，最後用n/10抹去最後一位，不斷循環到n<0
 **/