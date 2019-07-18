package todoapp.app;

import todoapp.core.Task;
import todoapp.core.TaskList;
import todoapp.core.TaskPosition;

/**
 * This is the application layer of the <b>A-Frame Architecture</b>. It uses <b>Logic Sandwich</b>.
 */
public class TheApp { // todo rename
    private final TaskRepository repository;

    public TheApp(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskList show() {
        return repository.find();
    }

    public TaskPosition create(String action) {
        TaskList tasks = repository.find();

        Task newTask = new Task(action);
        TaskList newTasks = tasks.add(newTask);

        repository.store(newTasks);

        return new TaskPosition(newTasks.size());
    }
}
