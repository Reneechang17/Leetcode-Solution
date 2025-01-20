// Medium
// BFS, Graph（DAG）
// Time:O(V+E), Space:O(V+E)
// https://leetcode.cn/problems/course-schedule/

import java.util.*;

class Solution {
    // Use graph to represent the course dependencies, and inDegree arr to count 
    //   how many prereq each course has
    // BFS: 1. Find no prereq course and add to the queue as start
    // 2. Process each course in the queue:
    //    a. Decrease the indegree of its neighboring courses (dependent courses)
    //    b. If a neighboring course's indegree becomes 0, add it to the queue
    // Finally, check if the number of completed courses equals to numCourses
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
        // find the start point: course with no prereq
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
