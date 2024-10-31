// Medium
// Binary Search
// O(n logm)
// https://leetcode.cn/problems/koko-eating-bananas/

class Solution {
    // 找到最小速度k，使得koko可以在h小时内吃完piles堆的香蕉
    // 因为这个piles的范围很大，到10^9，线性搜索不高效 -> 可以考虑用二分
    // 二分的是速度，最小为1，因为速度为0不合理
    // 最大为1e9，假设极端情况下每小时吃下一整堆
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = (int)1e9;

        while (left < right) {
            // mid是假设当前吃香蕉的速度
            int mid = (left + right) >> 1; 
            // 在速度为mid的时候，吃完piles堆香蕉的所需时间
            int hours = 0;
            for (int x : piles) {
                hours += (x + mid - 1) / mid; // 向上取整
            }

            // 如果在mid速度下可以完成，那就继续尝试更小的速度
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
