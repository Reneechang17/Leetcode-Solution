// Easy
// Iteration, Counting
// Time:O(1),Space:O(1)
// https://leetcode.cn/problems/finding-3-digit-even-numbers/

import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) {
            cnt[d]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int num = 100; num < 1000; num += 2) {
            // check cur num can formed by given num
            int[] tmpCnt = new int[10];
            int tmp = num;

            while (tmp > 0) {
                tmpCnt[tmp % 10]++;
                tmp /= 10;
            }

            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (tmpCnt[i] > cnt[i]) {
                    canForm = false;
                    break;
                }
            }
            if (canForm) {
                res.add(num);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
