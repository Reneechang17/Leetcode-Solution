// Easy
// Hash Table, Math
// O(logn)
// https://leetcode.cn/problems/happy-number/

import java.util.*;

class Solution {
    // we can use set to avoid the same number we process already
    // if we deal the same number again, it loops endlessly
    public boolean isHappy(int n) {
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
