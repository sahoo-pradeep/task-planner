import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TaskPlanner {
    private List<Sprint> sprints = new LinkedList<>();

    public Sprint addSprint(Sprint sprint) {
        sprints.add(sprint);
        return sprint;
    }

    public Sprint getSprint(String ticket) {
        Optional<Sprint> sprint =
                sprints.stream().filter(s -> s.getTicket().equals(ticket)).findFirst();
        return sprint.orElse(null);
    }

    public void displayUserStatus(String user){
        System.out.println();
        System.out.println("User: " + user);
        for (Sprint sprint : sprints){
            for (Task task : sprint.getTasks()){
                if (task.assignee != null && task.assignee.equalsIgnoreCase(user)){
                    System.out.println("\nTask Type: " + task.getClass().getName());
                    System.out.println("Title: " + task.getTitle());
                    System.out.println("Sprint: " + sprint.getSprintName());

                    if (task instanceof Story){
                        System.out.println("SubTrack: ");
                        for (SubTrack subTrack : ((Story) task).getSubTracks()){
                            System.out.println(subTrack.getTitle());
                        }
                    }
                }
            }
            System.out.println("\n");
        }
    }
}
