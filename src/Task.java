package src;

public class Task {
    private int taskId;
    private String taskName;
    private String dueDate;
    private String priority;

    public Task(int taskId, String taskName, String dueDate, String priority) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public int getTaskId() { return taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }

    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    @Override
    public String toString() {
        return "TaskID: " + taskId + ", Name: " + taskName + ", DueDate: " + dueDate + ", Priority: " + priority;
    }
}
