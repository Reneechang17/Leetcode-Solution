// Medium
// BFS, Graph（DAG）
// Time:O(V+E), Space:O(V+E)
// https://leetcode.cn/problems/course-schedule/

import java.util.*;

class Solution {
    // build the graph and determine the indegree of each course
    // indegree means how many prereq must be completed before it can be taken
    // BFS: 1. Find courses with no prereq (indegree == 0) and add to the queue as start
    // 2. Process each course in the queue:
    //    a. Decrease the indegree of its neighboring courses (dependent courses)
    //    b. If a neighboring course's indegree becomes 0, add it to the queue
    // Finally, check if the number of completed courses equals the numCourses
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
