package todoapp.app;

import todoapp.core.Task;
import todoapp.core.TaskList;
import todoapp.core.TaskPosition;

import java.util.Optional;

class FakeTaskRepository implements TaskRepository {

    private TaskList taskList;

    @Override
    public TaskList find() {
        return taskList;
    }

    @Override
    public Optional<Task> getTaskByPosition(TaskPosition position) {
        return taskList.get(position.index - 1);
    }

    @Override
    public void store(TaskList tasks) {
        this.taskList = tasks;
    }

}
