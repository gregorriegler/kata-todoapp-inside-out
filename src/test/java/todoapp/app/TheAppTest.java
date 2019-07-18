package todoapp.app;

import org.junit.jupiter.api.Test;
import todoapp.core.Task;
import todoapp.core.TaskList;

import static org.assertj.core.api.Assertions.assertThat;

public class TheAppTest {

    @Test
    void shouldDisplayTasksFromPersistence() {
        TaskRepository repository = new FakeTaskRepository();
        TaskList storedTaskList = new TaskList(new Task());
        repository.set(storedTaskList);

        var theApp = new TheApp(repository);

        var taskList = theApp.show();

        assertThat(taskList).isEqualTo(storedTaskList);
    }

}

class TheApp {
    public TheApp(TaskRepository repository) {
    }

    public TaskList show() {
        return null;
    }
}

class FakeTaskRepository implements TaskRepository {

    @Override
    public void set(TaskList taskList) {

    }
}

interface TaskRepository {
    void set(TaskList taskList);
}
