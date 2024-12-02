// Medium
// BFS, Graph（DAG）
// Time:O(V+E), Space:O(V+E)
// https://leetcode.cn/problems/course-schedule-ii/

import java.util.*;

class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
      List<List<Integer>> graph = new ArrayList<>();
      int[] inDegree = new int[numCourses];

      // initialize the graph and build the graph
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
      for (int i = 0; i < numCourses; i++) {
          // find the course with no prereq as start
          if (inDegree[i] == 0) {
              que.offer(i);
          }
      }
      int finish = 0;
      int[] res = new int[numCourses];
      while (!que.isEmpty()) {
          int curCourse = que.poll();
          res[finish] = curCourse;
          finish++;
          for (int nextCourse : graph.get(curCourse)) {
              inDegree[nextCourse]--;
              if (inDegree[nextCourse] == 0) {
                  que.offer(nextCourse);
              }
          }
      }
      if (finish != numCourses) {
          return new int[]{};
      } else {
          return res;
      }
  }
}
