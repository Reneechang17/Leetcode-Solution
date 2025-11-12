// Medium
// -
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/minimum-domino-rotations-for-equal-row/

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        // 把所有值都变成A[0]
        int rotationA = check(tops[0], tops, bottoms, n);
        // 如果不行&& tops[0]!=bottoms[0], 尝试把所有值都变成bottoms[0]
        if (rotationA != -1 || tops[0] == bottoms[0]) {
            return rotationA;
        } else {
            return check(bottoms[0], tops, bottoms, n);
        }
    }

    private int check(int target, int[] A, int[] B, int n) {
        int rotationA = 0, rotationB = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != target && B[i] != target) {
                return -1;
            } else if (A[i] != target) {
                rotationA++;
            } else if (B[i] != target) {
                rotationB++;
            }
        }
        return Math.min(rotationA, rotationB);
    }
}
