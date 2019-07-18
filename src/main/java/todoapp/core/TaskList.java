package todoapp.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskList {

    private final List<Task> tasks;

    public TaskList(Task... tasks) {
        this.tasks = new ArrayList<>(Arrays.asList(tasks));
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

    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public String toString() {
        return "TaskList{" + tasks + '}';
    }
}
