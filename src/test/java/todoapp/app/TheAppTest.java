package todoapp.app;

import org.junit.jupiter.api.Test;
import todoapp.core.Task;
import todoapp.core.TaskList;

import static org.assertj.core.api.Assertions.assertThat;

public class TheAppTest {

    @Test
    void shouldDisplayTasksFromPersistence() {
        var repository = new FakeTaskRepository();
        TaskList storedTaskList = new TaskList(new Task());
        repository.set(storedTaskList);

        var theApp = new TheApp(repository);

        var taskList = theApp.show();

        assertThat(taskList).isEqualTo(storedTaskList);
    }

}

class TheApp {
    private final TaskRepository repository;

    public TheApp(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskList show() {
        return repository.load();
    }
}

class FakeTaskRepository implements TaskRepository {

    private TaskList taskList;

    public void set(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public TaskList load() {
        return taskList;
    }
}

interface TaskRepository {
    TaskList load();
}
