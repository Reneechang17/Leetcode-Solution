// Medium
// Binary Search, Prefix Sum
// O(logn)
// https://leetcode.cn/problems/random-pick-with-weight/

import java.util.Random;

class Solution {
    // 權重越大的索引應該有更高的概率被選中
    // 假設數組w = [1,3,2]
    // 選取索引0的概率為 = 1 / (1+3+2) = 1/6
    // 選取索引1的概率為 = 3 / (1+3+2) = 3/6 -> 1/2
    // 選取索引2的概率為 = 2 / (1+3+2) = 2/6 -> 1/3
    // 構建前綴和數組，範圍是[1, sum]，sum是所有權重數組的總和
    // 二分查找找到前綴和數組第一個大於or等於r的位置
    private int[] prefixSum;
    private int totalSum;
    private Random random;

    public Solution(int[] w) {
        random = new Random();
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }

        totalSum = prefixSum[prefixSum.length - 1];
    }
    
    public int pickIndex() {
        // 選取一個隨機數，這個隨機數可以看作是在一條長度為totalSum的區間上隨機選擇一個點
        int randomNum = random.nextInt(totalSum) + 1;
        int left = 0, right = prefixSum.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if(prefixSum[mid] < randomNum) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
