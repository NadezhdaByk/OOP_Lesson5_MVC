package personal.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceFile implements Service {
    private TaskMapper mapper = new TaskMapper();
    private FileOperation fileOperation;

    public ServiceFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Task> getAllTask() {
        List<String> lines = fileOperation.readAllLines();
        List<Task> tasks = new ArrayList<>();
        for (String line : lines) {
            tasks.add(mapper.map(line));
        }
        return tasks;
    }

    @Override
    public String CreateTask(Task task) {
        List<Task> tasks = getAllTask();
        int max = 0;
        for (Task item : tasks) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        task.setId(id);
        saveTask(task, tasks);
        return id;
    }

//    public void updateUser(User user){
//        deleteUser(user.getId());
//        List<User> users = getAllUsers();
//        saveUser(user, users);
//    }
    private void saveTask(Task task, List<Task> tasks) {
        tasks.add(task);
        saveTasks(tasks);
    }

    @Override
    public void deleteTask(String taskID){
        List<Task> tasks = getAllTask();
        tasks.remove(findTask(taskID, tasks));
        saveTasks(tasks);
    }

    private Task findTask(String taskID, List<Task> tasks) {
        for (Task task : tasks) {
            if (task.getId().equals(taskID)) {
                return task;
            }
        }
        throw new IllegalStateException("Task not found!");
    }
    @Override
    public List<Task> getPriorityTask(String priority) {
        List<Task> tasks = getAllTask();
        List <Task> taskPrior = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equals(priority)) {
                taskPrior.add(task);
            }
            return taskPrior;
        }
        throw new IllegalStateException("Tasks of this priority not found!");
    }

    private void saveTasks(List<Task> tasks){
        List<String> lines = new ArrayList<>();
        for (Task item: tasks) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }
}
