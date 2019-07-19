package todoapp.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskListTest {

    @Test
    void shouldListEmptyTasks() {
        var taskList = createTaskList();

        assertThat(taskList.isEmpty()).isTrue();
        assertThat(taskList.get(firstPosition)).isEmpty();
    }

    @Test
    void shouldListSingleTask() {
        var givenTask = new Task("Buy Milk");
        var givenTasks = createTaskList(givenTask);

        assertThat(givenTasks.isEmpty()).isFalse();
        assertThat(givenTasks.get(firstPosition)).contains(givenTask);
    }

    @Test
    void shouldListOfTwoTasks() {
        var taskA = new Task("Buy Milk");
        var taskB = new Task("Feed Dog");
        var givenTasks = createTaskList(taskA, taskB);

        assertThat(givenTasks.isEmpty()).isFalse();
        assertThat(givenTasks.get(firstPosition)).contains(taskA);
        assertThat(givenTasks.get(secondPosition)).contains(taskB);
    }

    @Test
    void shouldAddTaskToList() {
        var taskList = createTaskList();

        var newTask = new Task("Buy Milk");
        taskList = taskList.add(newTask);

        assertThat(taskList.get(firstPosition)).contains(newTask);
    }

    final TaskList.Position firstPosition = new TaskList.Position(1);
    final TaskList.Position secondPosition = new TaskList.Position(2);

    private TaskList createTaskList(Task... tasks) {
        return new TaskList(tasks); // Signature Shielding
    }

    /*
    - delete an existing task
    - make it possible to edit tasks
    - make it possible to mark task as done
    - show open tasks (filter)
     */
}

