package main
// Hard
// https://leetcode.cn/problems/find-median-from-data-stream/

import "container/heap"

type MaxHeap []int

func (h MaxHeap) Len() int {return len(h)}
func (h MaxHeap) Less(i, j int) bool {return h[i] > h[j]}
func (h MaxHeap) Swap(i, j int) {h[i], h[j] = h[j], h[i]}

func (h *MaxHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}

func (h *MaxHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n - 1]
    *h = old[0 : n - 1]
    return x
}

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
    *h = old[0 : n - 1]
    return x
}

type MedianFinder struct {
    maxHeap *MaxHeap // left part
    minHeap *MinHeap // right part
}


func Constructor() MedianFinder {
    maxH := &MaxHeap{}
    minH := &MinHeap{}
    heap.Init(maxH)
    heap.Init(minH)

    return MedianFinder{
        maxHeap: maxH,
        minHeap: minH,
    }
}

// Time:O(logn), Space:O(n)
func (this *MedianFinder) AddNum(num int)  {
    // decide put which heap
    if this.maxHeap.Len() == 0 || num <= (*this.maxHeap)[0] {
        heap.Push(this.maxHeap, num)
    } else {
        heap.Push(this.minHeap, num)
    }

    // balance two heaps
    if this.maxHeap.Len() > this.minHeap.Len() + 1 {
        val := heap.Pop(this.maxHeap).(int)
        heap.Push(this.minHeap, val)
    } else if this.minHeap.Len() > this.maxHeap.Len() {
        val := heap.Pop(this.minHeap).(int)
        heap.Push(this.maxHeap, val)
    }
}

// Time:O(1), Space:O(n)
func (this *MedianFinder) FindMedian() float64 {
    if this.maxHeap.Len() > this.minHeap.Len() {
        return float64((*this.maxHeap)[0])
    }
    return (float64((*this.maxHeap)[0]) + float64((*this.minHeap)[0])) / 2.0
}
