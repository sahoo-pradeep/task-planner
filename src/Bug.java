import java.time.LocalDate;

public class Bug extends Task {
    private BugSeverity severity;
    private BugStatus status;

    public Bug(String title, String creator, String assignee, LocalDate dueDate,
            BugSeverity severity) {
        super(TicketGenerator.generate(), title, creator, assignee, dueDate);
        this.severity = severity;
        this.status = BugStatus.OPEN;
    }

    public BugStatus getStatus() {
        return status;
    }
}
