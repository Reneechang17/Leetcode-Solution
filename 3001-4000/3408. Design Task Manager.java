// Medium
// PriorityQueue, HashMap/Set
// https://leetcode.cn/problems/design-task-manager/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.List;

class TaskManager {
    // what I think is, we can use priority queue to store tasks
    class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private PriorityQueue<Task> pq;
    private Map<Integer, Task> taskMap; // taskId -> Task
    private Set<Integer> deletedTasks;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a.priority;
            }
            // order by taskId
            return b.taskId - a.taskId;
        });

        taskMap = new HashMap<>();
        deletedTasks = new HashSet<>();

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        pq.offer(task);
        taskMap.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        // mark as deleted
        deletedTasks.add(taskId);

        // add new task
        Task oldTask = taskMap.get(taskId);
        add(oldTask.userId, taskId, newPriority);
    }

    public void rmv(int taskId) {
        deletedTasks.add(taskId);
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task topTask = pq.poll();
            Task curTask = taskMap.get(topTask.taskId);

            if (curTask == null) {
                continue;
            }

            if (curTask == topTask ||
                    (curTask.userId == topTask.userId &&
                            curTask.priority == topTask.priority)) {
                taskMap.remove(topTask.taskId);
                return topTask.userId;
            }
        }
        return -1;
    }
}
