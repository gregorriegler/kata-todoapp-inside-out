package todoapp.system;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import todoapp.FrontController;
import todoapp.TodoApp;
import todoapp.core.Task;
import todoapp.core.TaskList;

abstract public class BaseAcceptanceIT {

    public static final int PORT = 4321;

    private TodoApp todoApp;
    private InMemoryTaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryTaskRepository();
        todoApp = new TodoApp(new FrontController(repository));
        todoApp.start(PORT);
        todoApp.awaitInitialization();
        RestAssured.port = PORT;
    }

    @AfterEach
    void tearDown() {
        todoApp.stop();
    }

    protected void givenTask(String action) {
        repository.store(new TaskList(new Task(action)));
    }
}
