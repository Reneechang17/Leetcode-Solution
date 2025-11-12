// Easy
// Array
// O(n)
// https://leetcode.cn/problems/can-place-flowers/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 需要種n朵花，但是不能有相鄰的 -> 遍歷檢查可以種花的位置（i==0）的左右兩側&邊界
        if (n == 0) return true;

        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean left = (i == 0 || flowerbed[i - 1] == 0);
                boolean right = (i == len - 1 || flowerbed[i + 1] == 0);

                if (left && right) {
                    flowerbed[i] = 1; // we can place the flower 
                    n--;
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
        // return n <= 0;
    }
}
