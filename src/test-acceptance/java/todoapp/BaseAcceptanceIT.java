package todoapp;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

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

    @Test
    void getHelloWorld() {
        get("/hello").then().body("hello", equalTo("world"));
    }

    @AfterEach
    void tearDown() {
        todoApp.stop();
    }
}
