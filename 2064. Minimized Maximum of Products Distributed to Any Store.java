
// For this question, we use binary search to find the max of each store' capacity.
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 0;
        for (int q : quantities) {
            right = Math.max(q, right); // the worse case is put one good all in same store
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid)) {
                right = mid; // try smaller
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canDistribute(int[] quantities, int n, int maxPerStore) {
        int store = 0;
        for (int q : quantities) {
            store += (q + maxPerStore - 1) / maxPerStore; // round up
            if (store > n)
                return false;
        }
        return true;
    }
}
