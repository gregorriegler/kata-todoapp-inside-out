package todoapp.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskListTest {

    @Test
    void shouldListEmptyTasks() {
        var taskList = new TaskList();
        assertThat(taskList.isEmpty()).isTrue();
    }

    @Test
    void shouldListSingleTask() {
        var givenTask = new Task("Buy Milk");
        var givenTasks = new TaskList(givenTask);

        assertThat(givenTasks.isEmpty()).isFalse();
        assertThat(givenTasks.getFirstTask()).contains(givenTask);
    }

    @Test
    void shouldListOfTwoTasks() {
        var taskA = new Task("Buy Milk");
        var taskB = new Task("Feed Dog");
        var givenTasks = new TaskList(taskA, taskB);

        assertThat(givenTasks.isEmpty()).isFalse();
        assertThat(givenTasks.getFirstTask()).contains(taskA);
        assertThat(givenTasks.get(1)).contains(taskB);
    }

    @Test
    void shouldAddTaskToList() {
        var taskList = new TaskList();

        var newTask = new Task("Buy Milk");
        taskList = taskList.add(newTask);

        assertThat(taskList.getFirstTask()).contains(newTask);
    }

    /*
    - delete an existing task
    - make it possible to edit tasks
    - make it possible to mark task as done
    - show open tasks (filter)
     */
}

