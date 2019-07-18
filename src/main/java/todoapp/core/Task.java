package todoapp.core;

import java.util.Objects;

/**
 * This is a value object. 
 */
public class Task {

    public final String action;

    public Task(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task that = (Task) obj;
        return Objects.equals(this.action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }

    @Override
    public String toString() {
        return "Task: " + action;
    }
}
