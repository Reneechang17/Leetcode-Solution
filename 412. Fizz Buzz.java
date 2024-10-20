// Easy
// Math, Simulation
// O(n)
// https://leetcode.cn/problems/fizz-buzz/

import java.util.*;

class Solution {
    // 直接模擬即可
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        // i start from 1
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
}
