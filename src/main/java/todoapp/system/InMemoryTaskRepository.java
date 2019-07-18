package todoapp.system;

import todoapp.app.TaskRepository;
import todoapp.core.Task;
import todoapp.core.TaskList;
import todoapp.core.TaskPosition;

import java.util.Optional;

/**
 * An <b>Infrastructure Wrappers</b>.
 */
public class InMemoryTaskRepository implements TaskRepository {

    private TaskList taskList = new TaskList();

    @Override
    public TaskList find() {
        return taskList;
    }

    @Override
    public Optional<Task> getTaskByPosition(TaskPosition position) {
        return taskList.get(position.index - 1); //todo extract
    }
    
    @Override
    public void store(TaskList tasks) {
        this.taskList = tasks;
    }

}
