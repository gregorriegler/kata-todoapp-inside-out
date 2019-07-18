package todoapp.app;

import org.junit.jupiter.api.Test;
import todoapp.core.Task;
import todoapp.core.TaskList;

import static org.assertj.core.api.Assertions.assertThat;

class TheAppTest {

    @Test
    void shouldDisplayTasksFromPersistence() {
        var storedTaskList = new TaskList(TASK);
        repository.store(storedTaskList);

        var theApp = new TheApp(repository);
        var taskList = theApp.show();

        assertThat(taskList).isEqualTo(storedTaskList);
    }

    @Test
    void shouldAddNewTaskToPersistence() {
        var storedTaskList = new TaskList();
        repository.store(storedTaskList);

        var theApp = new TheApp(repository);
        theApp.create("Buy Milk");

        // want verify(repository.store(newTaskList)
        Task firstTask = repository.find().getFirstTask();
        assertThat(firstTask).isEqualTo(new Task("Buy Milk"));
    }


    final Task TASK = new Task("irrelevant");

    FakeTaskRepository repository = new FakeTaskRepository();

}

