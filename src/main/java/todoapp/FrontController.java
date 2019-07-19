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
import todoapp.system.TaskListJsonMapper;

import java.util.Optional;

import static spark.Spark.after;
import static spark.Spark.delete;
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
        delete("/tasks/:pos", this::removeTask);
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

    private Object removeTask(Request req, Response res) {
        TaskList.Position position = positionFrom(req);

        Optional<Task> result = app.remove(position);

        JSONObject json = result.map(jsonMapper::toJson).orElse(new JSONObject());
        return json;
    }

    private TaskList.Position positionFrom(Request req) {
        int position = Integer.parseInt(req.params("pos"));
        return new TaskList.Position(position);
    }

    private Object notFound(Request req, Response res) {
        res.status(404);
        return "";
    }
}
