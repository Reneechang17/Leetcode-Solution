// Medium
// BFS, Graph（DAG）
// Time:O(V+E), Space:O(V+E)
// https://leetcode.cn/problems/course-schedule/

import java.util.*;

class Solution {
    // build the graph and determine the indegree of each course
    // BFS: 1. search for course which no need for prereq -> indegree == 0 -> as the start
    // 2. iterate the course and minus the indegree of nextCourse
    // 2.1 check that if one course's indegree is 0, then add to queue
    // finally check if the finished course is equal to the numCourses
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> que = new LinkedList<>();
        // find the course no need for prereq as the start
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
            }
        }

        int finish = 0;

        while (!que.isEmpty()) {
            int curCourse = que.poll();
            finish++;

            for (int nextCourse : graph.get(curCourse)) {
                inDegree[nextCourse]--;

                if (inDegree[nextCourse] == 0) {
                    que.offer(nextCourse);
                }
            }
        }
        return finish == numCourses;
    }
}
