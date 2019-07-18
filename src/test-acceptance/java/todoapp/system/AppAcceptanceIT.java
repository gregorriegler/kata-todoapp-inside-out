package todoapp.system;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
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

    @Test
    void getSingleTaskInList() {
        givenTask("Buy Milk");

        get("/tasks").
        then().
            statusCode(200).
            contentType(equalTo("application/json")).
            body("[0].action", equalTo("Buy Milk"));
            //.log().all();
    }

    @Test
    void createTask() {
        given().
            body("{ action:\"Feed Dog\" }").
            contentType("application/json").
            post("/tasks").
        then().
            statusCode(201).
            contentType(equalTo("application/json")).
            body("pos", equalTo(1));
    }

}