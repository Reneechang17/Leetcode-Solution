// Hard
// Binary Search, Greedy
// Time:O(log(min(n,m))·k·log(k)),Space:O(k)
// https://leetcode.cn/problems/maximum-number-of-tasks-you-can-assign/

import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // 排序
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int taskCnt = tasks.length, workerCnt = workers.length;

        // 对可能完成的任务数量做二分查找，范围是～min(tasks, workers)
        // 对每个可能的任务数量k，选择k个最简单的task和k个最强的工人
        int l = 0, r = Math.min(taskCnt, workerCnt), maxCanDo = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (checkCanDo(tasks, workers, pills, strength, mid)) {
                maxCanDo = mid;
                l = mid + 1; // try more
            } else {
                r = mid - 1;
            }
        }
        return maxCanDo;
    }

    private boolean checkCanDo(int[] tasks, int[] workers, int pills, int strength, int taskCnt) {
        if (taskCnt == 0) return true;
        int pillsRemaining = pills;

        // 用TreeMap追踪可用工人及其数量
        // key：工人的能力，val：该能力的工人数量
        TreeMap<Integer, Integer> worker = new TreeMap<>();

        // 选择最强的taskCnt个工人
        for (int i = workers.length - taskCnt; i < workers.length; i++) {
            int stre = workers[i];
            worker.put(stre, worker.getOrDefault(stre, 0) + 1);
        } 

        // 从最困难的任务开始分配（逆序）
        for (int i = taskCnt - 1; i >= 0; i--) {
            int taskDifficulty = tasks[i];

            // 尝试不使用药丸完成
            Integer topWorker = worker.lastKey();
            if (topWorker >= taskDifficulty) {
                removeWorker(worker, topWorker);
            } else if (pillsRemaining > 0) {
                // 使用药丸，寻找能力值满足(工人能力+药丸增益)>=任务难度的最弱工人
                Integer w = worker.ceilingKey(taskDifficulty - strength);
                if (w != null) {
                    removeWorker(worker, w);
                    pillsRemaining--;
                } else {
                    return false; // 即使使用pill也不能完成
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // 因为一个工人只能做一个活所以用了要remove
    private void removeWorker(TreeMap<Integer, Integer> worker, int s) {
        int cnt = worker.get(s);
        if (cnt == 1) {
            worker.remove(s);
        } else {
            worker.put(s, cnt - 1);
        }
    }
}
