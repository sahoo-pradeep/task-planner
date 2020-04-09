import java.time.LocalDate;

public class Feature extends Task {
    private String summary;
    private FeatureImpact impact;
    private FeatureStatus status;

    public Feature(String title, String creator, String assignee, LocalDate dueDate, String summary,
            FeatureImpact impact) {
        super(TicketGenerator.generate(), title, creator, assignee, dueDate);

        this.summary = summary;
        this.impact = impact;
        this.status = FeatureStatus.OPEN;
    }

    public FeatureStatus getStatus() {
        return status;
    }

    public void setStatus(FeatureStatus status) {
        this.status = status;
    }
}
