// Medium
// String
// Time:O(n*k),Space:O(k)
// https://leetcode.cn/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        // initialize the first one as "1"
        String res = "1";

        // generate 2~n
        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int i = 1; i < res.length(); i++) {
                if (res.charAt(i) == res.charAt(i - 1)) {
                    count++;
                } else {
                    sb.append(count).append(res.charAt(i - 1));
                    count = 1;
                }
            }
            sb.append(count).append(res.charAt(res.length() - 1));
            res = sb.toString();
            n--;
        }
        return res;
    }
}
