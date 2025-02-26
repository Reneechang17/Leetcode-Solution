// Medium
// Recursion
// Time:O(5^(n/2)),Space:O(5^(n/2))
// https://leetcode.cn/problems/strobogrammatic-number-ii/

import java.util.*;

class Solution {
    // valid number:0,1,6,8,9
    public List<String> findStrobogrammatic(int n) {
        List<String> res = helper(n);
        // remove invalid num with leading zeros if the len is greater than 1
        int len = res.size();
        for (int i = len - 1; i >= 0; i--) {
            String num = res.get(i);
            if (num.length() > 1 && num.charAt(0) == '0') {
                res.remove(i);
            }
        }
        return res;
    }
    private List<String> helper(int n) {
        List<String> res = new ArrayList<>();
        // base case for 0 or 1-length numbers
        if (n == 0) {
            res.add("");
        } else if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
        } else {
            // recursively build the numbers of len n by adding 
            // digits around smaller numbers
            List<String> lists = helper(n - 2);
            for (String list : lists) {
                res.add("0" + list + "0");
                res.add("1" + list + "1");
                res.add("6" + list + "9");
                res.add("8" + list + "8");
                res.add("9" + list + "6");
            }
        }
        return res;
    }
}
