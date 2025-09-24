// Medium
// Math
// Time:O(d), Space:O(d)
// https://leetcode.cn/problems/fraction-to-recurring-decimal/

import java.util.*;

// I can't have any comment on this question:D
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("denominator cannot be zero");
        
        if (numerator == 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();

        // check "-"
        boolean isNegative = false;
        if (numerator < 0 && denominator > 0) {
            isNegative = true;
        } else if (numerator > 0 && denominator < 0) {
            isNegative = true;
        }

        if (isNegative) {
            sb.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sb.append(num / den);
        num %= den;

        if (num == 0)
            return sb.toString();
        

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());

        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;

            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
}
