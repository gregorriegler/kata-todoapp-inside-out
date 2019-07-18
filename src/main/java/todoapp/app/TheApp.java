package todoapp.app;

import todoapp.core.Task;
import todoapp.core.TaskList;

public class TheApp {
    private final TaskRepository repository;

    public TheApp(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskList show() {
        return repository.find();
    }

    public void create(String action) {
        TaskList tasks = repository.find();

        Task newTask = new Task(action);
        TaskList newTasks = tasks.add(newTask);

        repository.store(newTasks);
    }
}
