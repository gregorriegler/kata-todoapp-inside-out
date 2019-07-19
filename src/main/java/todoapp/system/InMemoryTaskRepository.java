package todoapp.system;

import todoapp.app.TaskRepository;
import todoapp.core.Task;
import todoapp.core.TaskList;

import java.util.Optional;

/**
 * An <b>Infrastructure Wrappers</b>, in our situation this is the infrastructure.
 */
public class InMemoryTaskRepository implements TaskRepository {

    private TaskList taskList = new TaskList();

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
