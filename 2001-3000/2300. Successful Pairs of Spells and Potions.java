// Medium
// Binary Search, Array
// Time:O(nlogn), Space:O(1)
// https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];

        // Use binary search to find the first pos where spell * potion >= success.
        // From left to end are satisfied.
        // => potion >= success / spell
        // need to round up => [a/b] = (a+b-1)/b
        for (int i = 0; i < n; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i]; // round up

            int left = 0, right = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= minPotion) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            res[i] = m - left;
        }
        return res;
    }
}
