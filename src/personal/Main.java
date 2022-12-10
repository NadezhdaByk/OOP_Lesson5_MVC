package personal;

import personal.controllers.TaskController;
import personal.model.FileOperation;
import personal.model.FileOperationImpl;
import personal.model.Service;
import personal.model.ServiceFile;
import personal.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("tasks.txt");
        Service service = new ServiceFile(fileOperation);
        TaskController controller = new TaskController(service);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}
