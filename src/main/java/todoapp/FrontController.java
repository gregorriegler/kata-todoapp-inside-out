package todoapp;

import org.json.JSONObject;
import spark.Filter;
import todoapp.app.TaskRepository;

import static spark.Spark.after;
import static spark.Spark.get;

public class FrontController {

    private final TaskRepository repository;

    public FrontController(TaskRepository repository) {
        this.repository = repository;
    }

    public void create() {
        get("/hello", (req, res) -> {
            return new JSONObject().put("hello", "world").toString();
        });

        get("/tasks", (req, res) -> {
            res.status(200);
            return "[]";
        });

        get("*", (req, res) -> {
            res.status(404);
            return "";
        });

        after((Filter) (req, res) -> res.header("content-type", "application/json"));
    }
}
