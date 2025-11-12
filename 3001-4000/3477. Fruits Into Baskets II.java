// Easy
// Simulation
// Time:O(n+m), Space:O(m)
// https://leetcode.cn/problems/fruits-into-baskets-ii/

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] occupied = new boolean[baskets.length];
        int unplaced = 0;

        for (int f : fruits) {
            int basket = leftMost(baskets, occupied, f);
            if (basket == -1) {
                unplaced++;
            } else {
                // mark basket as occupied
                occupied[basket] = true;
            }
        }
        return unplaced;
    }

    private int leftMost(int[] baskets, boolean[] occupied, int fruitsQuantity) {
        for (int i = 0; i < baskets.length; i++) {
            if (!occupied[i] && baskets[i] >= fruitsQuantity) {
                return i;
            }
        }
        return -1;
    }
}
