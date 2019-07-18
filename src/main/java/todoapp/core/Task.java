package todoapp.core;

public class Task {

    private final String action;

    public Task(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Task: " + action;
    }
}
