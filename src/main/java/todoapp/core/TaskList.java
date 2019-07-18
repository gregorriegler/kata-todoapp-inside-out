package todoapp.core;

import java.util.Arrays;
import java.util.List;

public class TaskList {

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

    public Task get(int index) {
        return tasks.get(index);
    }

    @Override
    public String toString() {
        return "TaskList{" + tasks + '}';
    }
}
