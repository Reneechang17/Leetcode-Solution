import java.util.HashSet;
import java.util.Set;

// Easy
// Hash Table, Math
// O(logn)
// https://leetcode.com/problems/happy-number/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            int res = 0;
            while (n > 0) {
                int digit = n % 10;
                res += digit * digit;
                n = n / 10;
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