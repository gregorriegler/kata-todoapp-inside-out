package todoapp.system;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

class AppAcceptanceIT extends BaseAcceptanceIT {

    @Test
    void thereIsAnHttpApi() {
        get("/").
        then().
            statusCode(404);
    }

    @Test
    void getEmptyList() {
        get("/tasks").
        then().
            statusCode(200).
            contentType(equalTo("application/json")).
            body(equalTo("[]"));
    }

}