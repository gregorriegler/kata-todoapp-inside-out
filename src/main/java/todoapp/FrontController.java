package todoapp;

import org.json.JSONArray;
import org.json.JSONObject;
import spark.Filter;
import todoapp.app.TaskRepository;
import todoapp.app.TheApp;
import todoapp.core.Task;
import todoapp.core.TaskList;
import todoapp.core.TaskPosition;
import todoapp.system.InMemoryTaskRepository;

import static spark.Spark.*;

public class FrontController {

    private final TaskRepository repository;

    public FrontController() { // Parameterless Instantiation
        this(new InMemoryTaskRepository()); 
    }

    public FrontController(TaskRepository repository) {
        this.repository = repository;
    }

    public void create() { // todo rename to routes

        get("/tasks", (req, res) -> {
            res.status(200);

            TaskList taskList = repository.find(); // todo use "TheApp"
            JSONArray jsonArray = new JSONArray();
            taskList.forEach(task -> jsonArray.put(jsonOf(task)));

            return jsonArray;
        });

        post("/tasks", (req, res) -> {
            JSONObject incomingJson = new JSONObject(req.body());
            String action = incomingJson.getString("action");

            TheApp app = new TheApp(repository);
            TaskPosition position = app.create(action);

            res.status(201);
            return jsonOf(position.index);
        });

        get("*", (req, res) -> {
            res.status(404);
            return "";
        });

        after((Filter) (req, res) -> res.header("content-type", "application/json"));
    }

    // TODO move JSON mapping out to mapper class
    
    private JSONObject jsonOf(int index) {
        return new JSONObject().put("pos", index);
    }

    private JSONObject jsonOf(Task task) {
        return new JSONObject().put("action", task.action);
    }
}
