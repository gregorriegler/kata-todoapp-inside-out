package todoapp.app;

import todoapp.core.Task;
import todoapp.core.TaskList;
import todoapp.core.TaskPosition;

import java.util.Optional;
/**
 * This is an interface for an <b>Infrastructure Wrappers</b>.
 */
public interface TaskRepository {
    
    TaskList find();

    Optional<Task> getTaskByPosition(TaskPosition position); // todo taskpos maybe inner class of tasklist

    void store(TaskList tasks);

}
