package todoapp.core;

import java.util.Objects;

public class TaskPosition {

    public final int index; //todo rename to pos

    public TaskPosition(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TaskPosition that = (TaskPosition) obj;
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public String toString() {
        return "" + index;
    }
}
