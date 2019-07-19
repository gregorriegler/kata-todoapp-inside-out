package todoapp.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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

    public Optional<Task> get(Position position) {
        return get(position.asIndex());
    }

    Optional<Task> get(int index) {
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

    /**
     * This is a value object.
     */
    public static class Position {

        public final int position;

        public Position(int position) {
            this.position = position;
        }

        public int asIndex() {
            return position - 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Position that = (Position) obj;
            return position == that.position;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position);
        }

        @Override
        public String toString() {
            return "" + position;
        }
    }
}
