import java.time.LocalDate;
import java.util.Objects;

public abstract class Task {
    protected String ticket;
    protected String title;
    protected String creator;
    protected String assignee;
    protected LocalDate dueDate;

    public Task(String ticket, String title, String creator, String assignee, LocalDate dueDate) {
        this.ticket = ticket;
        this.title = title;
        this.creator = creator;
        this.assignee = assignee;
        this.dueDate = dueDate;
    }

    public String getTicket() {
        return ticket;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getAssignee() {
        return assignee;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Task task = (Task) o;
        return Objects.equals(ticket, task.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ticket);
    }
}
