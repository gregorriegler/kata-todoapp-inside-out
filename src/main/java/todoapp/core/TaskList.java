package todoapp.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Main logic with <b>Easily-Visible Behaviour</b> because of pure functions. 
 */
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

    public Optional<Task> get(int index) {
        if(index >= tasks.size()) {
            return Optional.empty();
        }
        return Optional.of(tasks.get(index));
    }

    public TaskList add(Task task) {
        return new TaskList(append(this.tasks, task));
    }

    public int size() {
        return tasks.size();
    }

    public void forEach(Consumer<Task> consumer) {
        tasks.forEach(consumer);
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
