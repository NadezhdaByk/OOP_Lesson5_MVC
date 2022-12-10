package personal.controllers;

import personal.model.Service;
import personal.model.Task;


import java.util.List;

public class TaskController {
    private final Service service;

    public TaskController(Service service) {
        this.service = service;
    }

    public void saveTask(Task task) {
        validateData(task);
        service.CreateTask(task);
    }

    public Task readTask(String taskId) throws Exception {
        List<Task> tasks = service.getAllTask();
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }

        throw new Exception("User not found");
    }

    public List<Task> readTasks() {
        return service.getAllTask();
    }

    public List<Task> getPriorityTask (String pr){
        return service.getPriorityTask(pr);
    }

    public void validateData(Task task) {
        if ((task.getName()).isEmpty() || (task.getAutor()).isEmpty() ||
                (task.getDateIn()).isEmpty() ||
                (task.getPriority()).isEmpty()) throw new IllegalStateException("Any fields are empty");
    }

    public void deleteTask( String id){
        service.deleteTask(id);
    }



}
