package main
// Medium
// Binary Search
// Time:O(nlogn), Space:O(n)
// https://leetcode.cn/problems/count-covered-buildings/

import "sort"
func countCoveredBuildings(n int, buildings [][]int) int {
    rowMap := make(map[int][]int)
    colMap := make(map[int][]int)

    for _, b := range buildings {
        x, y := b[0], b[1]
        rowMap[x] = append(rowMap[x], y)
        colMap[y] = append(colMap[y], x)
    }

    // sort each row and col
    for _, cols := range rowMap {
        sort.Ints(cols)
    }

    for _, rows := range colMap {
        sort.Ints(rows)
    }

    count := 0

    for _, b := range buildings {
        x, y := b[0],b[1]

        // check left and right(binary search)
        cols := rowMap[x]
        idx := sort.SearchInts(cols, y)
        hasLeft := idx > 0
        hasRight := idx < len(cols) - 1

        // check up and down
        rows := colMap[y]
        idx = sort.SearchInts(rows, x)
        hasUp := idx > 0
        hasDown := idx < len(rows) - 1

        if hasLeft && hasRight && hasUp && hasDown {
            count++
        }
    }
    return count
}
