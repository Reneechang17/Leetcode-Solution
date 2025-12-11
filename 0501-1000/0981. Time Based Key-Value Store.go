package main
// Medium
// HashMap, Binary Search
// https://leetcode.cn/problems/time-based-key-value-store/

type TimeMap struct {
    store map[string][]Pair
}

type Pair struct {
    timestamp int
    value string
}

func Constructor() TimeMap {
   return TimeMap{
    store: make(map[string][]Pair),
   } 
}

// Time:O(1), Space:O(n)
func (this *TimeMap) Set(key string, value string, timestamp int)  {
    this.store[key] = append(this.store[key], Pair {
        timestamp: timestamp,
        value: value,
    })
}

// Time:O(logm), Space:O(n)
func (this *TimeMap) Get(key string, timestamp int) string {
    pairs, exists := this.store[key]
    if !exists {
        return ""
    }

    // find the last pos that ts <= target
    left, right := 0, len(pairs) - 1
    res := -1

    for left <= right {
        mid := left + (right - left) / 2
        if pairs[mid].timestamp <= timestamp {
            // find a match, record and keep finding
            res = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    if res == -1 {
        return ""
    }
    return pairs[res].value
}
