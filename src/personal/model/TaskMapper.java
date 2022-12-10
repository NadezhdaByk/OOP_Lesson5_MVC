package personal.model;

public class TaskMapper {
//    JSONObject employeeDetails = new JSONObject();
//        employeeDetails.put("firstName", "Lokesh");
//        employeeDetails.put("lastName", "Gupta");

    public String map(Task task) {
        return String.format("%s,%s,%s,%s,%s", task.getId(), task.getName(), task.getAutor(), task.getDateIn(), task.getPriority());
    }

    public Task map(String line) {
        String[] lines = line.split(",");
        return new Task(lines[0], lines[1], lines[2], lines[3], lines[4]);
    }
}
