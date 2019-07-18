package todoapp.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskCoreDomainTest {

    @Test
    void shouldListEmptyTasks() {
        var the = new TaskCoreDomain(new TaskList());
        var tasks = the.listTasks();
        assertThat(tasks.isEmpty()).isTrue();
    }

    @Test
    void shouldListSingleTask() {
        var givenTask = new Task("Buy Milk");
        var givenTasks = new TaskList(givenTask);

        var the = new TaskCoreDomain(givenTasks);
        var tasks = the.listTasks();

        assertThat(tasks.isEmpty()).isFalse();
        assertThat(tasks.getFirstTask()).isEqualTo(givenTask);
    }

    @Test
    void shouldListOfTwoTasks() {
        var taskA = new Task("Buy Milk");
        var taskB = new Task("Feed Dog");
        var givenTasks = new TaskList(taskA, taskB);

        var the = new TaskCoreDomain(givenTasks);
        var tasks = the.listTasks();

        assertThat(tasks.isEmpty()).isFalse();
        assertThat(tasks.getFirstTask()).isEqualTo(taskA);
        assertThat(tasks.get(1)).isEqualTo(taskB);
    }

    @Test
    void shouldAddTaskToList() {
        var the = new TaskCoreDomain(new TaskList());

        var newTask = new Task("Buy Milk");
        the.addTask(newTask);

        var tasks = the.listTasks();
        assertThat(tasks.getFirstTask()).isEqualTo(newTask);
    }

    /*
    - create a new task

    - refactor task by index to optional

    - delete an existing task
    - make it possible to edit tasks
    - make it possible to mark task as done
    - show open tasks (filter)

    - register user with username
    - create role "creator" whom should be the only one allowed to create tasks
    - create role "doer" who should be the only one allowed to mark tasks as done

     */
}

