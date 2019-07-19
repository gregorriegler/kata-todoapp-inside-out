package todoapp;

import org.json.JSONArray;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
import todoapp.app.TaskRepository;
import todoapp.app.TodoApp;
import todoapp.core.TaskList;
import todoapp.system.InMemoryTaskRepository;
import todoapp.system.TaskListJsonMapper;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

public class FrontController {

    public static final String CONTENT_TYPE_HEADER = "content-type";
    public static final String CONTENT_APPLICATION_JSON = "application/json";

    private final TaskListJsonMapper jsonMapper = new TaskListJsonMapper();
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

        after((req, res) -> res.header(CONTENT_TYPE_HEADER, CONTENT_APPLICATION_JSON));
    }

    private Object getListOfTasks(Request req, Response res) {
        TaskList taskList = app.show();

        res.status(200);
        JSONArray json = jsonMapper.toJson(taskList);
        return json;
    }

    private Object createTask(Request req, Response res) {
        String action = jsonMapper.actionFromJson(req.body());

        TaskList.Position position = app.create(action);

        res.status(201);
        JSONObject json = jsonMapper.toJson(position);
        return json;
    }

    private Object notFound(Request req, Response res) {
        res.status(404);
        return "";
    }
}
