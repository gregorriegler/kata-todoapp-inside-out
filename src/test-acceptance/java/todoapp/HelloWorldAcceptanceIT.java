package todoapp;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

class HelloWorldAcceptanceIT extends BaseAcceptanceIT {

    @Test
    void getHelloWorld() {
        get("/hello").then().body("hello", equalTo("world"));
    }

}