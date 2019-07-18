package todoapp.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoreDomainTest {

    @Test
    void shouldListEmptyTasks() {
        var the = new CoreDomain(new TaskList());
        var tasks = the.listTasks();
        assertThat(tasks.isEmpty()).isTrue();
    }

    @Test
    void shouldListSingleTask() {
        var givenTask = new Task();
        var currentTasks = new TaskList(givenTask);

        var the = new CoreDomain(currentTasks);
        var tasks = the.listTasks();

        assertThat(tasks.isEmpty()).isFalse();
        assertThat(tasks.getFirstTask()).isEqualTo(givenTask);
    }

    // TODO complette Liste und dann nach aussen

    /*
    - create a new task
    - delete an existing task
    - make it possible to edit tasks
    - make it possible to mark task as done
    - show open tasks (filter)


    - register user with username
    - create role "creator" whom should be the only one allowed to create tasks
    - create role "doer" who should be the only one allowed to mark tasks as done

     */
}

class CoreDomain {
    private final TaskList tasks;

    public CoreDomain(TaskList tasks) {
        this.tasks = tasks;
    }

    public TaskList listTasks() {
        return tasks;
    }
}

class TaskList {

    private final List<Task> tasks;

    public TaskList(Task... tasks) {
        this.tasks = Arrays.asList(tasks);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public Task getFirstTask() {
        return tasks.get(0);
    }
}

class Task {

}
