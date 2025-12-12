package main
// Medium
// String, Sorting
// Time:O(ElogE + E*N), Space:O(n)
// https://leetcode.cn/problems/count-mentions-per-user/

import (
	"sort"
	"strconv"
	"strings"
)
func countMentions(numberOfUsers int, events [][]string) []int {
    mentions := make([]int, numberOfUsers)
    offlineTime := make([]int, numberOfUsers) // 0 means online

    sort.Slice(events, func(i, j int) bool {
        timeI, _ := strconv.Atoi(events[i][1])
        timeJ, _ := strconv.Atoi(events[j][1])

        if timeI != timeJ {
            return timeI < timeJ
        }

        if events[i][0] == "OFFLINE" && events[j][0] == "MESSAGE" {
            return true
        }
        return false
    })

    for _, event := range events {
        eventType := event[0]
        timestamp, _ := strconv.Atoi(event[1])

        if eventType == "OFFLINE" {
            userId, _ := strconv.Atoi(event[2])
            offlineTime[userId] = timestamp + 60
        } else if eventType == "MESSAGE" {
            mentionStr := event[2]

            if mentionStr == "ALL" {
                for i := 0; i < numberOfUsers; i++ {
                    mentions[i]++
                }
            } else if mentionStr == "HERE" {
                for i := 0; i < numberOfUsers; i++ {
                    if timestamp >= offlineTime[i] {
                        mentions[i]++
                    }
                }
            } else {
                // parse "id0 id1"
                tokens := strings.Split(mentionStr, " ")
                for _, t := range tokens {
                    if strings.HasPrefix(t, "id") {
                        userId, _ := strconv.Atoi(t[2:])
                        mentions[userId]++
                    }
                }
            }
        }
    }
    return mentions
}
