package personal.model;

import java.util.Date;

public class Task {
    private String name;
    private String autor;
    private String dateIn;
    private String id = "";
    private String priority;

    public Task(String name, String autor, String dateIn, String priority) {
        this.name = name;
        this.autor = autor;
        this.dateIn = dateIn;
        this.priority = priority;
    }

    public Task(String id, String name, String autor, String dateIn, String priority) {
        this.name = name;
        this.autor = autor;
        this.dateIn = dateIn;
        this.id = id;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", дело= " + name +
                ", инициатор-" + autor +
                ", дата заведения-" + dateIn +
                ", срочность -" + priority;
    }
}
