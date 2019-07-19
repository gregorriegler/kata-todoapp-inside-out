package todoapp;

import org.json.JSONArray;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
import todoapp.app.TaskRepository;
import todoapp.app.TodoApp;
import todoapp.core.Task;
import todoapp.core.TaskList;
import todoapp.system.InMemoryTaskRepository;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

public class FrontController {

    private final TodoApp app;

    public FrontController() { // Parameterless Instantiation
        this(new InMemoryTaskRepository());
    }

    public FrontController(TaskRepository repository) {
        this.app = new TodoApp(repository);
    }

    public void initRoutes() {
        get("/tasks", this::getListOfTasks);
        post("/tasks", this::createTask);
        get("*", this::notFound);

        after((req, res) -> res.header("content-type", "application/json"));
    }

    // TODO move JSON mapping out to mapper class
    private JSONObject jsonOf(int index) {
        return new JSONObject().put("pos", index);
    }

    private JSONObject jsonOf(Task task) {
        return new JSONObject().put("action", task.action);
    }

    private Object getListOfTasks(Request req, Response res) {
        TaskList taskList = app.show();

        JSONArray jsonArray = new JSONArray();
        taskList.forEach(task -> jsonArray.put(jsonOf(task)));
        res.status(200);
        return jsonArray;
    }

    private Object createTask(Request req, Response res) {
        JSONObject incomingJson = new JSONObject(req.body());
        String action = incomingJson.getString("action");

        TaskList.Position position = app.create(action);

        res.status(201);
        return jsonOf(position.position);
    }

    private Object notFound(Request req, Response res) {
        res.status(404);
        return "";
    }
}
