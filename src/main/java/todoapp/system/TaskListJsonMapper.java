package todoapp.system;

import org.json.JSONArray;
import org.json.JSONObject;
import todoapp.core.Task;
import todoapp.core.TaskList;

public class TaskListJsonMapper {

    public static final String TASK_ACTION_FIELD = "action";
    public static final String TASK_LIST_POSITION = "pos";

    public String actionFromJson(String body) {
        JSONObject json = new JSONObject(body);
        return json.getString(TASK_ACTION_FIELD);
    }

    public JSONObject toJson(Task task) {
        return new JSONObject().put(TASK_ACTION_FIELD, task.action);
    }

    public JSONArray toJson(TaskList taskList) {
        JSONArray jsonArray = new JSONArray();
        taskList.forEach(task -> jsonArray.put(toJson(task)));
        return jsonArray;
    }

    public JSONObject toJson(TaskList.Position position) {
        return new JSONObject().put(TASK_LIST_POSITION, position.position);
    }
}
