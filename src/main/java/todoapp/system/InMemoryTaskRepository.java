package todoapp.system;

import todoapp.app.TaskRepository;
import todoapp.core.TaskList;

public class InMemoryTaskRepository implements TaskRepository {

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
