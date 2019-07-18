package todoapp;

import org.json.JSONArray;
import org.json.JSONObject;
import spark.Filter;
import todoapp.app.TaskRepository;
import todoapp.core.Task;
import todoapp.core.TaskList;

import static spark.Spark.*;

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

            TaskList taskList = repository.find();
            JSONArray jsonArray = new JSONArray();
            taskList.forEach(task -> jsonArray.put(jsonOf(task)));

            return jsonArray;
        });

        post("/tasks", (req, res) -> {
            JSONObject incomingJson = new JSONObject(req.body());
            String action = incomingJson.getString("action");

            Task task = new Task(action);
            TaskList newList = repository.find().add(task);
            repository.store(newList);

            res.status(201);
            return jsonOf(task);
        });

        get("*", (req, res) -> {
            res.status(404);
            return "";
        });

        after((Filter) (req, res) -> res.header("content-type", "application/json"));
    }

    private JSONObject jsonOf(Task task) {
        return new JSONObject().put("action", task.action);
    }
}
