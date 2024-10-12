package Model;

import java.util.Objects;

/**
 *
 * Created by Frame-Code
 */
public class Task {
    private static int counter = 0;
    private int id;
    private String title;
    private String description;
    private boolean isCompleted;
    private String deadline;

    public Task(String title, String description, boolean isCompleted, String deadline) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
    }

    public Task(String title, String description, String deadline) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    // Method to check the task as completed
    public void checkToCompleted() {
        this.isCompleted = true;
    }

    // Method to pospone the deadline
    public void posponeDate(String newDeadline) {
        this.deadline = newDeadline;
    }

    //Method to print for screen the details fo the task
    public void showDetails() {
        String stateTask = isCompleted ? "Completada" : "Pendiente";
        System.out.println("ID: " + id);
        System.out.println("Título: " + title);
        System.out.println("Descripcion: " + description);
        System.out.println("Estado: " + stateTask);
        System.out.println("Fecha Límite: " + deadline);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", title=" + title + ", description=" + description + ", completed=" + isCompleted + ", deadline=" + deadline + '}';
    }
    
}
