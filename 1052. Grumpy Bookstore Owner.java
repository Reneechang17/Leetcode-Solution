// Medium
// Sliding Window
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/grumpy-bookstore-owner/

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0, save = 0, maxSave = 0, n = customers.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            } else if (grumpy[i] == 1) {
                save += customers[i];
            }

            if (i - j + 1> minutes) {
                if (grumpy[j] == 1) {
                    save -= customers[j];
                }
                j++;
            }
            maxSave = Math.max(save, maxSave);
        }
        return total + maxSave;
    }
}
