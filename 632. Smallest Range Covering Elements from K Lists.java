import java.util.List;
import java.util.PriorityQueue;

// Hard 
// Priority Queue
// O(N * log k)
// N: the elements in lists
// k: the number of lists
// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // 定義優先隊列（最小堆）維護當前考慮的元素，以確保可以快速取得最小值
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // 紀錄當前考慮元素的最大值
        int maxVal = Integer.MIN_VALUE;
        // 初始化最小區間起始&結束位置
        int start = -1, end = -1, minRange = Integer.MAX_VALUE;

        // 初始化優先隊列
        // 為了區分元素來自哪個列表
        // 隊列存儲的是一個三元組：（value, list_index, element_index)
        // 將每個列表的第一個元素以及其索引放入隊列
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[] { nums.get(i).get(0), i, 0 });
            maxVal = Math.max(maxVal, nums.get(i).get(0)); // 更新當前最大值
        }
        // 當優先隊列不為空的時候循環處理
        while (true) {
            int[] min = pq.poll(); // 從優先隊列中取出當前最小的元素
            // 獲取最小元素的值以及其在原列表中的位置
            int minVal = min[0], listIndex = min[1], eleIndex = min[2];

            // 如果當前的最小值與最大值的差小於已經紀錄的最小區間範圍，則更新區間
            if (maxVal - minVal < minRange) {
                minRange = maxVal - minVal;
                start = minVal;
                end = maxVal;
            }

            // 如果當前列表的元素已經取完，則退出循環
            if (eleIndex + 1 == nums.get(listIndex).size())
                break;

            // 否則，從相同列表中取下一個元素，放入優先隊列
            int nextVal = nums.get(listIndex).get(eleIndex + 1);
            pq.offer(new int[] { nextVal, listIndex, eleIndex + 1 });
            maxVal = Math.max(maxVal, nextVal);
        }
        // 返回最後計算出的最小區間
        return new int[] { start, end };
    }
}

/**
 * 思路：最小堆
 * 核心：從每個列表中選擇一個元素，使得這些元素的最大值和最小值的差最小
 **/