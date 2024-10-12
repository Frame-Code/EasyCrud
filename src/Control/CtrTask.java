package Control;

import Model.Task;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Frame-Code
 */
public class CtrTask {
    private List<Task> listTask = new ArrayList<>();

    public CtrTask() {
    }

    public void createTask(String title, String description, String deadline) {
        addTask(new Task(title, description, deadline));
    }

    public void addTask(Task task) {
        listTask.add(task);
    }

    public void editTask(Task task) {
        Task task1 = getTask(task.getId());
        task1.setId(task.getId());
        task1.setTitle(task.getTitle());
        task1.setDescription(task.getDescription());
        task1.setCompleted(task.isCompleted());
        task1.setDeadline(task.getDeadline());

    }

    public Task getTask(int id) {
        return listTask.get(id);
    }

    public List<Task> getListTask() {
        return listTask;
    }

    public void deleteTask(int id) {
        listTask.remove(id);
    }

}
