package todoapp.app;

import todoapp.core.Task;
import todoapp.core.TaskList;
import todoapp.core.TaskPosition;

import java.util.Optional;

public interface TaskRepository {
    TaskList find();

    void store(TaskList tasks);

    Optional<Task> getTaskByPosition(TaskPosition position); // todo taskpos maybe inner class of tasklist
}
