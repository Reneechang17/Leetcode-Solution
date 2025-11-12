// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/

class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast = head, slow = head;
        // fast go 'cnt' steps further
        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
        }
        // fast and slow go forward together until reach fast end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // now slow point to the cnt node from the end 
        return slow;
    }
}
