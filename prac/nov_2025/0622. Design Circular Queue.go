package main
// Medium
// https://leetcode.cn/problems/design-circular-queue/

type MyCircularQueue struct {
    arr []int
    head int
    tail int
    size int
    count int 
}


func Constructor(k int) MyCircularQueue {
    return MyCircularQueue{
        arr: make([]int, k),
        head: 0,
        tail: -1,
        size: k,
        count: 0,
    }
}


func (this *MyCircularQueue) EnQueue(value int) bool {
    if this.IsFull() {
        return false
    }

    // move tail and insert
    this.tail = (this.tail + 1) % this.size 
    this.arr[this.tail] = value 
    this.count++
    return true
}


func (this *MyCircularQueue) DeQueue() bool {
    if this.IsEmpty() {
        return false
    }

    this.head = (this.head + 1) % this.size
    this.count--
    return true
}


func (this *MyCircularQueue) Front() int {
    if this.IsEmpty() {
        return -1
    }
    return this.arr[this.head]
}


func (this *MyCircularQueue) Rear() int {
    if this.IsEmpty() {
        return -1
    }
    return this.arr[this.tail]
}


func (this *MyCircularQueue) IsEmpty() bool {
    return this.count == 0
}


func (this *MyCircularQueue) IsFull() bool {
    return this.count == this.size
}
