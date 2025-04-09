// Hard
// Stack
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/next-greater-element-iv/

import java.util.*;

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        // s1 store indexs that haven't found first greater element
        // s2 store indexs that found first greater but not sec greater
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();

        for (int i = 0; i < n; i++) {
            // process elements that found first greater
            // and check if cur is sec greater
            while (!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
                res[s2.pop()] = nums[i]; // 
            }

            // temp to store the elements need to move to s2
            Stack<Integer> tmp = new Stack<>();

            // process elements that haven't found first greater
            while (!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
                tmp.push(s1.pop());
            }

            // move elements that found first greater to s2
            while (!tmp.isEmpty()) {
                s2.push(tmp.pop());
            }

            s1.push(i); // push cur to s1 and wait for its first greater
        }
        return res;
    }
}

// every time we occur new element, if it greater than peek element
// it can be first greater or second greater
// so we can use stack to store those elements and compare with peek instead of brute force to nested compare(cost O(n^2))
