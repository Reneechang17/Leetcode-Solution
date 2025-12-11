package main
// Medium
// Time:O(1), Space:O(1)
// https://leetcode.cn/problems/design-hit-counter/

// Use time bucket to store. Because freq ops on slice is not decent and cost memory in Go.
// But if using python, we can easily use deque.

type HitCounter struct {
    times []int
    hits []int
}


func Constructor() HitCounter {
    return HitCounter{
        times: make([]int, 300),
        hits: make([]int, 300),
    }
}


func (this *HitCounter) Hit(timestamp int)  {
    index := timestamp % 300

    if this.times[index] != timestamp {
        this.times[index] = timestamp
        this.hits[index] = 1
    } else {
        this.hits[index]++
    }
}


func (this *HitCounter) GetHits(timestamp int) int {
    total := 0
    for i := 0; i < 300; i++ {
        if timestamp - this.times[i] < 300 {
            total += this.hits[i]
        }
    }
    return total
}
