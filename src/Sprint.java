import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sprint {
    private String ticket;
    private String sprintName;
    private List<Task> tasks = new LinkedList<>();

    public Sprint(String sprintName) {
        this.ticket = TicketGenerator.generate();
        this.sprintName = sprintName;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void displaySprintStatus() {
        LocalDate now = LocalDate.now();

        List<Task> nonCompletedTask = tasks.stream().filter(task -> {
            if (task instanceof Feature && !((Feature) task).getStatus()
                    .equals(FeatureStatus.DEPLOYED)) {
                return true;
            } else if (task instanceof Bug && !((Bug) task).getStatus().equals(BugStatus.FIXED)) {
                return true;
            } else if (task instanceof Story && !((Story) task).getStatus()
                    .equals(StoryStatus.COMPLETED)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        List<Task> onTrackTasks = new LinkedList<>();
        List<Task> delayedTasks = new LinkedList<>();

        nonCompletedTask.forEach(task -> {
            if (task.dueDate.compareTo(now) < 0){
                delayedTasks.add(task);
            } else {
                onTrackTasks.add(task);
            }
        });

        System.out.println("Sprint Title: " + sprintName);
        System.out.print("\nOn Track Tasks: \n");
        onTrackTasks.forEach(task -> System.out.println(task.title));
        System.out.println();
        System.out.print("Delayed Tasks: \n");
        delayedTasks.forEach(task -> System.out.println(task.title));
    }

    public String getTicket() {
        return ticket;
    }

    public String getSprintName() {
        return sprintName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Sprint sprint = (Sprint) o;
        return Objects.equals(ticket, sprint.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }
}
