package main
// Medium
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/redundant-connection/

func findRedundantConnection(edges [][]int) []int {
    n := len(edges)
    parent := make([]int, n + 1) // node start from 1

    for i := 1; i <= n; i++ {
        parent[i] = i
    }

    for _, edge := range edges {
        u, v := edge[0], edge[1]
        
        if find(parent, u) == find(parent, v) {
            return edge
        }

        union(parent, u, v)
    }
    return nil
}

func find(parent []int, x int) int {
    if parent[x] != x {
        parent[x] = find(parent, parent[x])
    }
    return parent[x]
}

func union(parent []int, x, y int) {
    rootX := find(parent, x)
    rootY := find(parent, y)
    if rootX != rootY {
        parent[rootX] = rootY
    }
}
