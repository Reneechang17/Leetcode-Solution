// Medium
// String, Recursion
// Time:O(n*k),Space:O(k)
// https://leetcode.cn/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String res = "1"; // initialize first one as "1"

        // generate 2~n
        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int i = 1; i < res.length(); i++) {
                if (res.charAt(i) == res.charAt(i - 1)) {
                    count++; // if same as prev, cnt++
                } else {
                    sb.append(count).append(res.charAt(i - 1));
                    count = 1;
                }
            }
            // deal with last char
            sb.append(count).append(res.charAt(res.length() - 1));
            res = sb.toString();

            n--;
        }
        return res;
    }
}
