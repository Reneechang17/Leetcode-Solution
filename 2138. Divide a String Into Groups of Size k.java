// Easy
// String
// Time:O(max(n,k)), Space:O(1)
// https://leetcode.cn/problems/divide-a-string-into-groups-of-size-k/

import java.util.*;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();
        int cur = 0, n = s.length();
        while (cur < n) {
            int end = Math.min(cur + k, n);
            res.add(s.substring(cur, end));
            cur += k;
        }
        String last = res.get(res.size() - 1);
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            res.set(res.size() - 1, last);
        }
        return res.toArray(new String[0]);
    }
}
