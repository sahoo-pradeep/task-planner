import java.time.LocalDate;
import java.util.Objects;

public class TaskFactory {
    public static Feature createFeature(String title, String creator, String assignee,
            LocalDate dueDate, String summary, FeatureImpact impact) {
        Objects.requireNonNull(title, "Title cannot be empty");
        Objects.requireNonNull(creator, "Creator cannot be empty");
        Objects.requireNonNull(dueDate, "Due Date cannot be empty");
        Objects.requireNonNull(summary, "Summary cannot be empty");
        Objects.requireNonNull(impact, "Impact cannot be empty");
        return new Feature(title, creator, assignee, dueDate, summary, impact);
    }

    public static Bug createBug(String title, String creator, String assignee, LocalDate dueDate,
            BugSeverity severity) {
        Objects.requireNonNull(title, "Title cannot be empty");
        Objects.requireNonNull(creator, "Creator cannot be empty");
        Objects.requireNonNull(dueDate, "Due Date cannot be empty");
        Objects.requireNonNull(severity, "Severity cannot be empty");
        return new Bug(title, creator, assignee, dueDate, severity);
    }

    public static Story createStory(String title, String creator, String assignee, LocalDate dueDate,
            String summary) {
        Objects.requireNonNull(title, "Title cannot be empty");
        Objects.requireNonNull(creator, "Creator cannot be empty");
        Objects.requireNonNull(dueDate, "Due Date cannot be empty");
        Objects.requireNonNull(summary, "Summary cannot be empty");
        return new Story(title, creator, assignee, dueDate, summary);
    }

    public static SubTrack createSubTrack(String title, Story story){
        Objects.requireNonNull(title, "Title cannot be empty");
        Objects.requireNonNull(story, "Story cannot be empty");
        if (story.getStatus().equals(StoryStatus.COMPLETED)){
            throw new RuntimeException("SubTrack can't be added to Completed Story");
        }

        SubTrack subTrack = new SubTrack(title);
        story.addSubTrack(subTrack);
        return subTrack;
    }
}
