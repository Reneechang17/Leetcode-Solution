// Medium
// Binary Search, Greedy
// Time:O(nlogn), Space:O(1)
// https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/

import java.util.Arrays;

class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = price[price.length - 1] - price[0];

        // Use binary search to find the tastiness
        while (left < right) {
            // remember left = mid -> need + 1 (round up)
            // right = mid no + 1
            // This prevents infinite loops when the search range narrows
            // to two adjacent numbers.
            int mid = (left + right + 1) / 2; 
            if (canSelect(price, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canSelect(int[] price, int k, int minDiff) {
        int cnt = 1;
        int prev = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - prev >= minDiff) {
                cnt++;
                prev = price[i];
                if (cnt == k)
                    return true;
            }
        }
        return false;
    }
}
