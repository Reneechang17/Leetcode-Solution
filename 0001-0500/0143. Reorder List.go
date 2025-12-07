package main
// Medium
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/reorder-list/

func reorderList(head *ListNode)  {
    if head == nil || head.Next == nil {
        return
    }

    // find mid 
    slow, fast := head, head
    for fast.Next != nil && fast.Next.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }

    // reverse second part
    second := reverse(slow.Next)
    slow.Next = nil

    // merge two linkedlists
    first := head
    for second != nil {
        tmp1 := first.Next
        tmp2 := second.Next

        first.Next = second
        second.Next = tmp1

        first = tmp1
        second = tmp2
    }
}

func reverse(head *ListNode) *ListNode {
    var prev *ListNode
    cur := head

    for cur != nil {
        nextNode := cur.Next
        cur.Next = prev
        prev = cur
        cur = nextNode
    }
    return prev
}
