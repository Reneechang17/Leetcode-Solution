package main
// Medium
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/partition-list/

func partition(head *ListNode, x int) *ListNode {
    lessDummy := &ListNode{}
    greaterDummy := &ListNode{}

    less := lessDummy
    greater := greaterDummy
    cur := head

    for cur != nil {
        if cur.Val < x {
            less.Next = cur
            less = less.Next
        } else {
            greater.Next = cur
            greater = greater.Next
        }
        cur = cur.Next
    }
    greater.Next = nil
    less.Next = greaterDummy.Next
    return lessDummy.Next
}
