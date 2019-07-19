package todoapp.app;

import todoapp.core.Task;
import todoapp.core.TaskList;

import java.util.Optional;

class FakeTaskRepository implements TaskRepository {

    private TaskList taskList;

    @Override
    public TaskList find() {
        return taskList;
    }

    @Override
    public Optional<Task> getTaskByPosition(TaskList.Position position) {
        return taskList.get(position);
    }

    @Override
    public void store(TaskList tasks) {
        this.taskList = tasks;
    }

}
