package todoapp.system;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

class AppAcceptanceIT extends BaseAcceptanceIT {

    @Test
    void thereIsAnHttpApi() {
        get("/").
        then().
            statusCode(404);
    }

//   @Test
//    void getEmptyList() {
//        get("/tasks").
//        then().
//            contentType(equalTo("application/json")).
//            statusCode(200).
//            body(equalTo("[]"));
//    }

}