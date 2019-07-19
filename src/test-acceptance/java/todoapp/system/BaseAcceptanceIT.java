package todoapp.system;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import todoapp.FrontController;
import todoapp.TodoAppServer;
import todoapp.core.Task;
import todoapp.core.TaskList;

abstract public class BaseAcceptanceIT {

    public static final int PORT = 4321;

    private TodoAppServer todoAppServer;
    private InMemoryTaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryTaskRepository();
        todoAppServer = new TodoAppServer(new FrontController(repository));
        todoAppServer.start(PORT);
        todoAppServer.awaitInitialization();
        RestAssured.port = PORT;
    }

    @AfterEach
    void tearDown() {
        todoAppServer.stop();
    }

    protected void givenTask(String action) {
        repository.store(new TaskList(new Task(action)));
    }
}
