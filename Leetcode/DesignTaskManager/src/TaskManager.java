import java.util.*;

class TaskManager {
    PriorityQueue<Task> p = new PriorityQueue<>((t1, t2) -> t2.getPriority() == t1.getPriority() ? t2.getTaskId()- t1.getTaskId() : t2.getPriority() - t1.getPriority());
    Map<Integer, Task> m = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        p.add(t);
        m.put(taskId, t);
    }

    public void edit(int taskId, int newPriority) {
        Task t = m.get(taskId);
        t.setValid(false);
        Task t2 = new Task(t.getUserId(), t.getTaskId(), newPriority);
        p.add(t2);
        m.put(taskId, t2);
    }

    public void rmv(int taskId) {
        Task t = m.get(taskId);
        t.setValid(false);
    }

    public int execTop() {
        Task t;
        do {
            t = p.poll();
            if (t == null) return -1;
        } while (!t.getIsValid());

        rmv(t.getTaskId());
        return t.getUserId();
    }
}

class Task {
    int userId;
    int taskId;
    int priority;
    boolean isValid;

    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
        this.isValid = true;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setValid(boolean valid) {
        this.isValid = valid;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getPriority() {
        return priority;
    }

    public int getUserId() {
        return userId;
    }

    public boolean getIsValid() {
        return isValid;
    }
}
