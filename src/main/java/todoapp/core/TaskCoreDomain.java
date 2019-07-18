package todoapp.core;

class TaskCoreDomain {
    private final TaskList tasks;

    public TaskCoreDomain(TaskList tasks) {
        this.tasks = tasks;
    }

    public TaskList listTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
