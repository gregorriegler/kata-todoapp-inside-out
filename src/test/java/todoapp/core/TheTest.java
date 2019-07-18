package todoapp.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TheTest {

    @Test
    void shouldListEmptyTasks() {
        var the = new The();
        var tasks = the.listTasks();
        assertThat(tasks.isEmpty()).isTrue();
    }

}

class The {
    public TaskList listTasks() {
        return new TaskList();
    }
}

class TaskList {

    public boolean isEmpty() {
        return true;
    }
}
