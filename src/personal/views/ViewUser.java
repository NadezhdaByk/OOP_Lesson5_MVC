package personal.views;

import personal.controllers.TaskController;
import personal.exception.CommandException;
import personal.model.Task;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private TaskController taskController;

    public ViewUser(TaskController taskController) {
        this.taskController = taskController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command);
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown command");
                continue;
            }
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    try {
                        String name = prompt("Дело: ");
                        String autor = prompt("Инициатор: ");
                        String priority = prompt("Приоритет: ");
                        String dataIn = (new Date()).toString();
                        taskController.saveTask(new Task(name, autor, dataIn, priority));
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                case READ:
                    String id = prompt("Идентификатор задачи: ");
                    try {
                        Task task = taskController.readTask(id);
                        System.out.println(task);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    taskController.readTasks().forEach(System.out::println);
                    break;
                case LISTPRIOR:
                    String priority = prompt("Срочность задачи: ");
                    taskController.getPriorityTask(priority).forEach(System.out::println);
                    break;
                case DELETE:
                    String idDel = prompt("Идентификатор задачи: ");
                    try {
                       taskController.deleteTask(idDel);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
