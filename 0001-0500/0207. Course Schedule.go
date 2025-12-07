package main
// Medium
// Time:O(V+E), Space:O(V+E)
// https://leetcode.cn/problems/course-schedule/

func canFinish(numCourses int, prerequisites [][]int) bool {
    graph := make([][]int, numCourses)
    indegree := make([]int, numCourses)

    for _, pre := range prerequisites {
        course := pre[0]
        p := pre[1]
        graph[p] = append(graph[p], course)
        indegree[course]++
    }

    que := []int{}
    for i := 0; i < numCourses; i++ {
        if indegree[i] == 0 {
            que = append(que, i)
        }
    }

    count := 0
    for len(que) > 0 {
        cur := que[0]
        que = que[1:]
        count++

        for _, next := range graph[cur] {
            indegree[next]--
            if indegree[next] == 0 {
                que = append(que, next)
            }
        }
    }
    return count == numCourses
}
