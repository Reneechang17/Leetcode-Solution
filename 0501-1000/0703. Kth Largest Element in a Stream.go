package main
// Easy
// MinHeap
// Time:O(logk), Space:O(k)
// https://leetcode.cn/problems/kth-largest-element-in-a-stream/

import "container/heap"

// Use minHeap, keep the size to k, and the top is the Kth largest

type MinHeap []int

func (h MinHeap) Len() int {return len(h)}
func (h MinHeap) Less(i, j int) bool {return h[i] < h[j]}
func (h MinHeap) Swap(i, j int) {h[i], h[j] = h[j], h[i]}

func (h *MinHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}

func (h *MinHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n - 1]
    *h = old[0:n-1]
    return x
}

type KthLargest struct {
    k int
    heap *MinHeap
}


func Constructor(k int, nums []int) KthLargest {
    h := &MinHeap{}
    heap.Init(h)

    kth := KthLargest {
        k: k,
        heap: h,
    }

    for _, num := range nums {
        kth.Add(num)
    }
    return kth
}


func (this *KthLargest) Add(val int) int {
    heap.Push(this.heap, val)

    if this.heap.Len() > this.k {
        heap.Pop(this.heap)
    }
    return (*&*this.heap)[0]
}
