// Easy
// HashMap
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/strobogrammatic-number/

import java.util.*;

class Solution {
    // valid number:0,1,8,6,9
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int left = 0, right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if (!map.containsKey(leftChar) || map.get(leftChar) != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
