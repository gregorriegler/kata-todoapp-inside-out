package todoapp.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public Optional<Task> getFirstTask() {
        return get(0);
    }

    public Optional<Task> get(int index) {
        return Optional.of(tasks.get(index));
    }

    public TaskList add(Task task) {
        return new TaskList(append(this.tasks, task));
    }

    private static <T> List<T> append(List<T> list, T element) {
        List<T> tasks = new ArrayList<>(list);
        tasks.add(element);
        return tasks;
    }

    @Override
    public String toString() {
        return "TaskList{" + tasks + '}';
    }
}
