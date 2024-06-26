// Medium
// Array, Matrix
// O(n^2)
// Similar: 54
// https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int cnt = 1;
        int x1 = 0, x2 = n, y1 = 0, y2 = n;

        while (cnt <= n * n) {
            for (int i = y1; i < y2; i++) {
                ans[x1][i] = cnt++;
            }
            x1++;

            for (int i = x1; i < x2; i++) {
                ans[i][y2 - 1] = cnt++;
            }
            y2--;

            for (int i = y2 - 1; i >= y1; i--) {
                ans[x2 - 1][i] = cnt++;
            }
            x2--;

            for (int i = x2 - 1; i >= x1; i--) {
                ans[i][y1] = cnt++;
            }
            y1++;
        }
        return ans;
    }
}

/**
 * 螺旋矩陣思路：一個while四個for
 * 和54的差別：需要自己定義填數器、矩陣、四個邊界
 * 
 * 初始化：定義n*n矩陣以及填數器，填數器從1開始
 *  四個邊界：行邊界（上下），列邊界（左右）
 * 
 * 邊界處理邏輯：
 * 1. 處理上邊界，從左（x1）到右（x2）填充數字，然後上邊界下移（第一行直接廢了，換到第二行，這樣第二部分的填充右邊 
 *    界，會從第二行開始填）=>  x1++
 *    Note: 這部分填充的是：第0行第一列、第0行第二列、第0行第三列、第0行第n列，意思就是要遍歷的是列，從y1開始到y2結束
 * 2. 處理右邊界，從上（y1）到下（y2）填充數字，然後右邊界左移（最右邊那列廢了，下次從倒數第二列開始填）=> y2--
 *    Note: 這部分填充的是：第x1行第y2-1列、第x1+1行第y2-1列、第x1+2行第y2-1列、第x2行第y2-1列，意思就是要遍歷的
 *    是行，從x1開始到x2結束。
 * 3. 處理下邊界，注意是從右到左填，所以是i--，遍歷的是列，從y2-1到y1（i≥ y1），行就是x2-1，然後下邊界上移 =>  x2--
 * 4. 處理左邊界，注意是從下往上填，所以也是i--，遍歷的是行，從x2-1到 x1（i≥x1)，列就是y1，然後左邊界右移 =>  y1++
 * 
 * 最後返回矩陣
 **/