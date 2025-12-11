package main
// Medium
// Time: O(1), Space: O(k)
// https://leetcode.cn/problems/design-circular-deque/

type MyCircularDeque struct {
    arr []int
    head int
    tail int
    size int
    count int
}


func Constructor(k int) MyCircularDeque {
    return MyCircularDeque{
        arr: make([]int, k),
        head: 0,
        tail: 0,
        size: k,
        count: 0,
    }
}


func (this *MyCircularDeque) InsertFront(value int) bool {
    if this.IsFull() {
        return false
    }
    
    // head move left
    // + size to prevent negative
    this.head = (this.head - 1 + this.size) % this.size
    this.arr[this.head] = value
    this.count++
    return true
}


func (this *MyCircularDeque) InsertLast(value int) bool {
    if this.IsFull() {
        return false
    }

    this.arr[this.tail] = value
    // tail move right
    this.tail = (this.tail + 1) % this.size
    this.count++
    return true
}


func (this *MyCircularDeque) DeleteFront() bool {
    if this.IsEmpty() {
        return false
    }
    
    // head move right
    this.head = (this.head + 1) % this.size
    this.count--
    return true
}


func (this *MyCircularDeque) DeleteLast() bool {
    if this.IsEmpty() {
        return false
    }

    // tail move left
    // + size to prevent negative
    this.tail = (this.tail - 1 + this.size) % this.size
    this.count--
    return true
}


func (this *MyCircularDeque) GetFront() int {
    if this.IsEmpty() {
        return -1
    }
    return this.arr[this.head]
}


func (this *MyCircularDeque) GetRear() int {
    if this.IsEmpty() {
        return -1
    }

    // since tail point to the next empty slot => -1
    idx := (this.tail - 1 + this.size) % this.size
    return this.arr[idx]
}


func (this *MyCircularDeque) IsEmpty() bool {
    return this.count == 0
}


func (this *MyCircularDeque) IsFull() bool {
    return this.count == this.size
}
