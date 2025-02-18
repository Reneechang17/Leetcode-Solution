// Medium
// String, Stack
// O(n)
// https://leetcode.cn/problems/exclusive-time-of-functions/

import java.util.*;

class Solution {
    // 要求計算每個函數在一段時間內的獨佔時間， 題目有提到棧，可以用棧來模擬
    // 一個函數開始時：入棧，結束時出棧，計算上一個時間戳的時間差 -> 棧中要存放id，一個變量保存時間
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    // 將棧頂函數的佔有時間累加
                    res[stack.peek()] += time - prevTime;
                }
                stack.push(id); // 函數開始執行壓入棧
                prevTime = time; // 更新上一個時間戳
            } else {
                res[stack.pop()] += time - prevTime + 1; // +1表示包含當前結束的時刻
                prevTime = time + 1; // 更新上一個紀錄的時間
            }
        }
        return res;
    }
}

/**
 * 思路：當一個函數開始時入棧，結束時彈出棧，計算他的獨佔時間。用棧來紀錄每個函數id，再用一個變量紀錄上一個時間戳，方便計算時間差
 * 這題的操作可以透過log中的type來判斷，start表示函數開始，end表示函數結束（可以用java中的split方法分割字符串獲取）
 * 當遍歷到start時，將當前時間到上一個時間戳的時間累加到棧頂函數上，然後將當前函數壓入棧，更新上一個時間戳
 * 而遍歷到end時，表示函數結束了，將當前時間到上一個時間戳的時間累加到棧頂函數上，然後將棧頂函數彈出，更新上一個時間戳
 * Note：注意結束時累加的是stack.pop()那個（即彈出的），並且時間要+1，包含當前的時間
 * 而更新上一個時間戳時也要在time上+1，因為結束時間是包含在內的
 **/
