package todoapp;

import org.json.JSONObject;

import static spark.Spark.get;

public class Routes {

    public void create() {
        get("/hello", (req, res) -> {
            res.header("content-type", "application/json");
            return new JSONObject().put("hello", "world").toString();
        });
    }
}
