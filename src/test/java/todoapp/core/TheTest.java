package todoapp.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TheTest {

    @Test
    void shouldListEmptyTasks() {
        var the = new The(new TaskList());
        var tasks = the.listTasks();
        assertThat(tasks.isEmpty()).isTrue();
    }

    @Test
    void shouldListSingleTask() {
        var givenTask = new Task();
        var currentTasks = new TaskList(givenTask);

        var the = new The(currentTasks);
        var tasks = the.listTasks();

        assertThat(tasks.isEmpty()).isFalse();
        assertThat(tasks.getFirstTask()).isEqualTo(givenTask);
    }

}

class The {
    private final TaskList tasks;

    public The(TaskList tasks) {
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
