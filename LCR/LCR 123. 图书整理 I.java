// Easy
// Stack
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

import java.util.Stack;

class Solution {
    public int[] reverseBookList(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
