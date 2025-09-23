// Medium
// String
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/compare-version-numbers/

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] p1 = version1.split("\\.");
        String[] p2 = version2.split("\\.");

        int maxLen = Math.max(p1.length, p2.length);

        for (int i = 0; i < maxLen; i++) {
            // if (i < p1.length) {
            //     v1 = Integer.parseInt(p1[i]);
            // } else {
            //     v1 = 0;
            // }

            // if (i < p2.length) {
            //     v2 = Integer.parseInt(p2[i]);
            // } else {
            //     v2 = 0;
            // }

            int v1 = (i < p1.length) ? Integer.parseInt(p1[i]) : 0;
            int v2 = (i < p2.length) ? Integer.parseInt(p2[i]) : 0;

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0;
    }
}
