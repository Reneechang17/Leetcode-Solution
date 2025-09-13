// Medium
// Greedy
// Time:O(a+b), Space:O(1)
// https://leetcode.cn/problems/string-without-aaa-or-bbb/

class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();

        while (a > 0 || b > 0) {
            boolean setA = false;

            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) == sb.charAt(n - 2)) {
                if (sb.charAt(n - 1) == 'b') {
                    setA = true;
                }
            } else {
                setA = (a >= b);
            }

            // write
            if (setA) {
                sb.append('a');
                a--;
            } else {
                sb.append('b');
                b--;
            }
        }
        return sb.toString();
    }
}
