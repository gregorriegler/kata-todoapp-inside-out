package todoapp.app;

import todoapp.core.TaskList;

public interface TaskRepository {
    TaskList find();

    void store(TaskList tasks);
}
