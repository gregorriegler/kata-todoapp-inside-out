package todoapp.app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import todoapp.core.Task;
import todoapp.core.TaskList;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class TodoAppTest {

    @Test
    void shouldDisplayTasksFromPersistence() {
        var storedTaskList = new TaskList(someTask);
        repository.store(storedTaskList);

        var taskList = todoApp.show();

        assertThat(taskList).isEqualTo(storedTaskList);
    }

    @Test
    void shouldAddNewTaskToPersistence() {
        repository.store(new TaskList());

        TaskList.Position indexCreated = todoApp.create("Buy Milk");

        // want verify(repository.store(newTaskList)
        Optional<Task> firstTask = repository.getTaskByPosition(indexCreated);
        assertThat(firstTask).contains(new Task("Buy Milk"));
    }

    @Test
    void shouldReturnRemovedTask() {
        var storedTaskList = new TaskList(someTask);
        repository.store(storedTaskList);

        Optional<Task> removed = todoApp.remove(new TaskList.Position(1));

        assertThat(removed).contains(someTask);
    }

    @Test
    @Disabled("too many tests")
    void shouldRemoveExistingTaskFromPersistence() {
        var storedTaskList = new TaskList(someTask);
        repository.store(storedTaskList);

        todoApp.remove(new TaskList.Position(1));

        TaskList persistedList = repository.find();
        assertThat(persistedList.isEmpty()).isTrue();
    }

    // - leave out feature for remove non existing

    // TODO custom matcher

    final Task someTask = new Task("irrelevant");

    FakeTaskRepository repository = new FakeTaskRepository();
    TodoApp todoApp = new TodoApp(repository);

}

