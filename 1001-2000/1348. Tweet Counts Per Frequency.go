package main
// Medium
// https://leetcode.cn/problems/design-in-memory-file-system/

type TweetCounts struct {
    tweets map[string][]int // tweetName -> ts arr(sorted)
}


func Constructor() TweetCounts {
    return TweetCounts{
        tweets: make(map[string][]int),
    }
}


func (this *TweetCounts) RecordTweet(tweetName string, time int)  {
    times := this.tweets[tweetName]

    left, right := 0, len(times)
    for left < right {
        mid := left + (right - left) / 2
        if times[mid] < time {
            left = mid + 1
        } else {
            right = mid
        }
    }

    // insert to left
    times = append(times[:left], append([]int{time}, times[left:]...)...)
    this.tweets[tweetName] = times
}


func (this *TweetCounts) GetTweetCountsPerFrequency(freq string, tweetName string, startTime int, endTime int) []int {
    times := this.tweets[tweetName]
    delta := 60
    if freq == "hour" {
        delta = 3600
    } else if freq == "day" {
        delta = 86400
    }

    res := []int{}

    for start := startTime; start <= endTime; start += delta {
        end := min(start + delta - 1, endTime)
        count := this.countInRange(times, start, end)
        res = append(res, count)
    }
    return res
}

func (this *TweetCounts) countInRange(times []int, left, right int) int {
    start := this.lowerBound(times, left)
    end := this.upperBound(times, right)
    return end - start
}

func (this *TweetCounts) lowerBound(arr []int, target int) int {
    left, right := 0, len(arr)
    for left < right {
        mid := left + (right - left) / 2
        if arr[mid] < target {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

func (this *TweetCounts) upperBound(arr []int, target int) int {
    left, right := 0, len(arr)
    for left < right {
        mid := left + (right - left) / 2
        if arr[mid] <= target {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}
