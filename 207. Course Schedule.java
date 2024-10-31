// Medium
// BFS, Graph（DAG）
// O(V+E)
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

/**
 * 課程安排：這題是經典的拓撲排序，也是一個有向無環圖DAG問題，判斷給定的課程是否可以根據某些先修課程順利完成
 * 給定numCourses表示需要完成的課程，課程之間有先修條件，每個可能都用一個數字表示，如果有1->0這樣的先修條件，表示需要先完成0才可以修1
 * 現要判斷是否可以順利完成課程，即判斷課程先修關係是否有環
 * 
 * 思路：
 * 1. 入度：入度表示一個節點有多少邊指向他，在本題中，入度可以表示每門課有多少先修課程，如果一門課的入度為0，說明這門課沒有先修課，可以直接修
 * 2. BFS：首先找所有入度為0的課，表示這些課不需要先修課，可以直接修，加入隊列中，可以作為學習的起點
 * 然後遍歷隊列中的節點，把他們出隊列，並將他們指向的後續課程入度減1。當一門課程的入度減為0時，表示他的先修課已經修完了，可以加入隊列中
 * 如果最終可以學習所有課程，說明這個課程安排是合理的，否則說明有環，無法完成所有課程
 **/
