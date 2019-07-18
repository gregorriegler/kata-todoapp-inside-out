package todoapp.app;

import org.junit.jupiter.api.Test;
import todoapp.core.Task;
import todoapp.core.TaskList;
import todoapp.core.TaskPosition;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class TheAppTest {

    @Test
    void shouldDisplayTasksFromPersistence() {
        var storedTaskList = new TaskList(TASK);
        repository.store(storedTaskList);

        var taskList = theApp.show();

        assertThat(taskList).isEqualTo(storedTaskList);
    }

    @Test
    void shouldAddNewTaskToPersistence() {
        repository.store(new TaskList());

        TaskPosition indexCreated = theApp.create("Buy Milk");

        // want verify(repository.store(newTaskList)
        Optional<Task> firstTask = repository.getTaskByPosition(indexCreated);
        assertThat(firstTask).contains(new Task("Buy Milk"));
    }


    final Task TASK = new Task("irrelevant");

    FakeTaskRepository repository = new FakeTaskRepository();
    TheApp theApp = new TheApp(repository);

}

