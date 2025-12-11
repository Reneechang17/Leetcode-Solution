package main
// Easy
// Time:O(1), Space:O(n)
// https://leetcode.cn/problems/logger-rate-limiter/

// Need to store message and timestamp, and need O(1) lookup and update -> HashMap

type Logger struct {
    lastPrint map[string]int
}


func Constructor() Logger {
    return Logger{
        lastPrint: make(map[string]int),
    }
}


func (this *Logger) ShouldPrintMessage(timestamp int, message string) bool {
    if lastTime, exists := this.lastPrint[message]; exists {
        if timestamp - lastTime < 10 {
            return false
        }
    }
    this.lastPrint[message] = timestamp
    return true
}
