package todoapp.system;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import todoapp.TodoApp;

abstract public class BaseAcceptanceIT {

    public static final int PORT = 4321;

    private TodoApp todoApp;

    @BeforeEach
    void setUp() {
        todoApp = new TodoApp();
        todoApp.start(PORT);
        todoApp.awaitInitialization();
        RestAssured.port = PORT;
    }

    @AfterEach
    void tearDown() {
        todoApp.stop();
    }
}
