// Medium
// String, Recursion
// Time:O(n^3),Space:O(n)
// https://leetcode.cn/problems/additive-number/

// Use BigInteger since testcase need it...:>
import java.math.BigInteger;
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String first = num.substring(0, i);
                String second = num.substring(i, j);
                // ignore leading zero
                if ((first.length() > 1 && first.charAt(0) == '0') || (second.length() > 1 && second.charAt(0) == '0')) {
                    continue;
                }

                BigInteger x = new BigInteger(first);
                BigInteger y = new BigInteger(second);
                String remaining = num.substring(j);

                // recursively check following digits
                while (remaining.length() > 0) {
                    BigInteger sum = x.add(y);
                    String sumStr = sum.toString();
                    if (!remaining.startsWith(sumStr)) {
                        break;
                    }
                    // update x and y and keep validation
                    remaining = remaining.substring(sumStr.length());
                    x = y;
                    y = sum;
                }
                if (remaining.length() == 0) return true;
            }
        }
        return false;
    }
}
