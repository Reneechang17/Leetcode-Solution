// Medium
// Heap
// Time: O((n+k) logn), Space: O(n)
// https://leetcode.cn/problems/maximum-average-pass-ratio/

import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 用最大堆 -> 加一個學生的提升幅度，從大到小排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((classA, classB) -> {
            double gainA = calculateGain(classA[0], classA[1]);
            double gainB = calculateGain(classB[0], classB[1]);

            // 提升大的排在前面
            if (gainB > gainA)
                return 1;
            if (gainB < gainA)
                return -1;
            return 0;
        });

        // put all classes in pq
        for (int[] c : classes) {
            pq.offer(c);
        }

        // assign extra students
        for (int s = 0; s < extraStudents; s++) {
            // 拿出“提升最大”的班級
            int[] best = pq.poll();

            int passCnt = best[0], totalCnt = best[1];

            // add a student
            passCnt = passCnt + 1;
            totalCnt = totalCnt + 1;

            best[0] = passCnt;
            best[1] = totalCnt;

            pq.offer(best);
        }
        
        double totalPassRatio = 0.0;
        int n = classes.length;

        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            int passCnt = c[0], totalCnt = c[1];

            double passRatio = (double) passCnt / totalCnt;
            totalPassRatio = totalPassRatio + passRatio;
        }

        return totalPassRatio / n;
    }

    private double calculateGain(int curPass, int curTotal) {
        double curRatio = (double) curPass / curTotal;
        double newRatio = (double) (curPass + 1) / (curTotal + 1);
        return newRatio - curRatio;
    }
}
