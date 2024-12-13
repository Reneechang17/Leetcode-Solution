// Medium
// Array
// Time:O(N),Space:O(1)
// https://leetcode.cn/problems/majority-element-ii/

import java.util.*;

class Solution {
    // Use the Boyer-Moore Voting Algorithm to find potential candidates for majority elements
    //  appear more than n/3
    // First pass: identify two candidates that could be the majority elements
    // Second pass: verify the candidates by counting their occurrences
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        // Use two distinct initial values
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;

        // First Pass: find candidates
        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) res.add(candidate1);
        if (count2 > nums.length / 3) res.add(candidate2);

        return res;
    }
}

/**
 * 這題也是用Boyer-Moore算法來解，求出現次數超過n/3的所有元素，並且找出最多兩個可能的候選者
 * 
 * 那麼初始化為兩個candidate（注意兩個初始化需要為不同值，這裡一個是0一個是1），以及兩個計數器
 * Step1:選擇候選者：遍歷數組，如果當前元素等於candidate1，則count1++，同理candidate2
 * 如果count1為零，則將當前元素設為新的candidate1，並重置count1 = 1（同理count2）
 * 如果當前元素既不是candidate1也不是candidate2，同時減少count1和count2
 * Step2:驗證候選者：再遍歷數組，計算candidate1 和 candidate2實際出現的次數，並檢查每個候選者是否真的超過 n/3
 **/
