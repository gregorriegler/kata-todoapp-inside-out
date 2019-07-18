package todoapp.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskList {

    private final List<Task> tasks;

    public TaskList(Task... tasks) {
        this(Arrays.asList(tasks));
    }

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
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

    public TaskList add(Task task) {
        ArrayList<Task> tasks = new ArrayList<>(this.tasks);
        tasks.add(task);
        return new TaskList(tasks);
    }

    @Override
    public String toString() {
        return "TaskList{" + tasks + '}';
    }
}
