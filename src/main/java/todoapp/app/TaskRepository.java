package todoapp.app;

import todoapp.core.Task;
import todoapp.core.TaskList;

import java.util.Optional;

/**
 * This is an interface for an <b>Infrastructure Wrappers</b>.
 */
public interface TaskRepository {

    TaskList find();

    Optional<Task> getTaskByPosition(TaskList.Position position);

    void store(TaskList tasks);

}
