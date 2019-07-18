package todoapp.app;

import todoapp.core.TaskList;

class FakeTaskRepository implements TaskRepository {

    private TaskList taskList;

    @Override
    public TaskList find() {
        return taskList;
    }

    @Override
    public void store(TaskList tasks) {
        this.taskList = tasks;
    }
}
