// Easy
// Hash Table
// O(n)
// https://leetcode.cn/problems/majority-element/

import java.util.*;

class Solution {
    // the more striaght-forward method is use hashmap
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > majorityCount) {
                return num;
            }
        }
        return -1;
    }
}

class Solution2 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}

/**
 * 這題有很多種解法，像是這種找最多的可以用哈希表統計，也可以用排序，其中間的元素一定是超過半數的元素
 * 
 * 這題的最優解是 Boyer-Moore算法 -> 用於尋找數組中的多數元素（即出現次數超過數組大小一半的元素）
 * 這個算法所基於的客觀事實為：每次從數組中找出一對不同的元素，將他們從數組中刪除，這麼做不會影響數組的多數元素
 * 
 * 初始化：候選者從第一個元素開始，計數器count為0
 * Step1:選擇候選者（candidate）：遍歷數組每一個元素，如果當前count為0，假設當前元素為候選者。
 * 如果之後遍歷到的元素等於當前的候選者，就將count+1，如果不等則count-1
 * 
 * Step2:驗證候選者：第一階段結束後，候選者是可能的多數元素，但這種方法無法找到的候選者真的是多數
 * 但如果題目保證一定有多數元素，則直接返回候選者即可（本題如此）
 * 否則，需要再次遍歷數組，統計候選者的出現次數，確定是否其真的是多數元素
 **/
