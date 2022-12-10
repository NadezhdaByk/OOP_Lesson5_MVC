package personal.model;

import java.util.List;

public interface Service {
    List<Task> getAllTask();
    List<Task> getPriorityTask(String priority);
    String CreateTask(Task task);
//    void updateUser(User user);
    void deleteTask(String userID);

}
