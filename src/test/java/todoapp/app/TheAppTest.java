package todoapp.app;

import org.junit.jupiter.api.Test;
import todoapp.core.Task;
import todoapp.core.TaskList;

import static org.assertj.core.api.Assertions.assertThat;

public class TheAppTest {

    @Test
    void shouldDisplayTasksFromPersistence() {
        var repository = new FakeTaskRepository();
        TaskList storedTaskList = new TaskList(new Task("irrelevant"));
        repository.set(storedTaskList);

        var theApp = new TheApp(repository);

        var taskList = theApp.show();

        assertThat(taskList).isEqualTo(storedTaskList);
    }

    @Test
    void shouldAddNewTaskToPersistence() {
        var repository = new FakeTaskRepository();
        TaskList storedTaskList = new TaskList();
        repository.set(storedTaskList);

        var theApp = new TheApp(repository);

        theApp.create("Buy Milk");

        assertThat(storedTaskList.getFirstTask()).isEqualTo(new Task("Buy Milk"));
    }

}

class TheApp {
    private final TaskRepository repository;

    public TheApp(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskList show() {
        //TODO: no TaskCoreDomain here
        return repository.load();
    }

    public void create(String action) {
        // this is not what we want
        repository.load().add(new Task(action));
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
