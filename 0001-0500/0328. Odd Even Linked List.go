package main
// Medium
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/odd-even-linked-list/

type ListNode struct {
	Val int
	Next *ListNode
}

func oddEvenList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }

    odd := head
    even := head.Next
    evenHead := even // later connect with odd

    for even != nil && even.Next != nil {
        odd.Next = even.Next
        odd = odd.Next

        even.Next = odd.Next
        even = even.Next
    }
    odd.Next = evenHead
    return head
}
