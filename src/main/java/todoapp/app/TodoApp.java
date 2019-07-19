package todoapp.app;

import todoapp.core.Task;
import todoapp.core.TaskList;

import java.util.Optional;

/**
 * This is the application layer of the <b>A-Frame Architecture</b>. It uses <b>Logic Sandwich</b>.
 */
public class TodoApp {
    private final TaskRepository repository;

    public TodoApp(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskList show() {
        return repository.find();
    }

    public TaskList.Position create(String action) {
        TaskList tasks = repository.find();

        Task newTask = new Task(action);
        TaskList newTasks = tasks.add(newTask);

        repository.store(newTasks);

        return new TaskList.Position(newTasks.size());
    }

    public Optional<Task> remove(TaskList.Position position) {
        TaskList list = repository.find();

        var result = list.remove(position);
        repository.store(result.first);

        return result.second;
    }
}
