// Medium
// Hash Table, Design
// https://leetcode.cn/problems/design-a-todo-list/

import java.util.*;

class TodoList {
  private int taskId;
  private Map<Integer, Set<Integer>> userTasks;
  private Map<Integer, Task> tasks;

  public TodoList() {
      taskId = 0;
      userTasks = new HashMap<Integer, Set<Integer>>();
      tasks = new HashMap<Integer, Task>();
  }
  
  public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
      taskId++;
      userTasks.putIfAbsent(userId, new HashSet<Integer>());
      userTasks.get(userId).add(taskId);
      Task task = new Task(taskId, taskDescription, dueDate, tags);
      tasks.put(taskId, task);
      return taskId;
  }
  
  public List<String> getAllTasks(int userId) {
      List<Task> tasksList = new ArrayList<Task>();
      Set<Integer> tasksSet = userTasks.getOrDefault(userId, new HashSet<Integer>());
      for (int id : tasksSet) {
          Task task = tasks.get(id);
          tasksList.add(task);
      }
      Collections.sort(tasksList, (a, b) -> a.getDueDate() - b.getDueDate());
      List<String> res = new ArrayList<String>();
      for (Task task : tasksList) {
          res.add(task.getDescription());
      }
      return res;
  }
  
  public List<String> getTasksForTag(int userId, String tag) {
      List<Task> tasksList = new ArrayList<Task>();
      Set<Integer> tasksSet = userTasks.getOrDefault(userId, new HashSet<Integer>());
      for (int id : tasksSet) {
          Task task = tasks.get(id);
          if (task.getTags().contains(tag)) {
              tasksList.add(task);
          }
      }
      Collections.sort(tasksList, (a, b) -> a.getDueDate() - b.getDueDate());
      List<String> res = new ArrayList<String>();
      for (Task task : tasksList) {
          res.add(task.getDescription());
      }
      return res;
  }
  
  public void completeTask(int userId, int taskId) {
      Set<Integer> set = userTasks.getOrDefault(userId, new HashSet<Integer>());
      if (set.contains(taskId) && tasks.containsKey(taskId)) {
          set.remove(taskId);
          tasks.remove(taskId);
      }
  }
}

class Task {
  private int id;
  private String description;
  private int dueDate;
  private Set<String> tags;

  public Task(int id, String description, int dueDate, List<String> tags) {
      this.id = id;
      this.description = description;
      this.dueDate = dueDate;
      this.tags = new HashSet<String>(tags);
  }

  public int getId() {
      return id;
  }

  public String getDescription() {
      return description;
  }

  public int getDueDate() {
      return dueDate;
  }

  public Set<String> getTags() {
      return tags;
  }
}
