package main
// Easy
// Time:O(1), Space:O(size)
// https://leetcode.cn/problems/moving-average-from-data-stream/

// There's no in-built deque in go, so instead of using append and cut the size every time,
// using Ring buffer would be better and stable.

type MovingAverage struct {
    arr []int
    size int
    count int 
    sum int
    head int
}


func Constructor(size int) MovingAverage {
    return MovingAverage{
        arr: make([]int, size),
        size: size,
    }
}


func (this *MovingAverage) Next(val int) float64 {
    if this.count == this.size {
        this.sum -= this.arr[this.head]
    }
    this.arr[this.head] = val
    this.sum += val
    
    this.head = (this.head + 1) % this.size
    
    if this.count < this.size {
        this.count++
    }

    return float64(this.sum) / float64(this.count)
}
