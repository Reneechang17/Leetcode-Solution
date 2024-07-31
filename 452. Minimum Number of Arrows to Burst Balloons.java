// Medium
// Array， Greedy, Sorting
// O(n logn)
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}

/**
 * 最少數量的箭引爆氣球
 * 二維空間中有許多氣球，一支弓箭可以沿著x軸從不同點完全垂直地射出，在座標x處射出一支箭，若有一個氣球的直徑的開始和結束座標滿足xstart<=x<=xend，則該氣球會被引爆
 * 可以射出的弓箭數量沒有限制，弓箭一旦被射出，可以無限前進，我們想找到使得所有氣球全部被引爆所需的弓箭最小數量
 * 
 * 思路：可以先按照start的位置做一个sort
 * 在遍歷氣球看當前氣球和當前的前一個氣球有沒有挨在一起，如果i的起始位置在i-1的右邊，那麼就要把count++，需要另一支箭把當前的氣球射掉
 * 如果重疊，代表他們可以一起被射掉，那就更新當前氣球和前一個氣球中end位置比較小的，這樣可以最大限度的射爆更多氣球
 **/