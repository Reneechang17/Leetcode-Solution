// Medium
// Math
// Time:O(n³), Space: O(1)
// https://leetcode.cn/problems/find-the-number-of-ways-to-place-people-i/

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length, cnt = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // they are in the same position
                if (i == j) continue;
                
                int aX = points[i][0], aY = points[i][1];
                int bX = points[j][0], bY = points[j][1];
                
                // b should be right-bottom of a
                if (bX < aX || bY > aY) continue;
                
                // check if some body in the range
                boolean isValid = true;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int x = points[k][0], y = points[k][1];
                    
                    // check if k inside the range (exclu boundary)
                    if (x >= aX && x <= bX && y <= aY && y >= bY) {
                        isValid = false;
                        break;
                    }
                }
                
                if (isValid) cnt++;
            }
        }
        return cnt;
    }
}
