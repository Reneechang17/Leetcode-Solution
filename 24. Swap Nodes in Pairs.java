// Medium
// LinkedList, Recursion
// O(n)
// https://leetcode.com/problems/swap-nodes-in-pairs/

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode temp;
        ListNode firstNode, secondNode;
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode; // Step1: dummy point to the second node
            secondNode.next = firstNode; // Step2: second node point to the first node
            firstNode.next = temp; // Step3: first node point to the temp
            cur = firstNode; // move forward cur to do the recursion
        }
        return dummy.next;
    }
}

/**
 * 思路：
 * 1. 虛擬頭節點(此時為cur)指向第二個節點
 * Note:需要先用一個temp保存第二個節點的下一個節點，避免之後被覆蓋
 * 2. 第二個節點指向第一個節點
 * 3. 第一個節點指向原本第二個節點的下一個節點(temp)
 * 4. move forward cur
 **/