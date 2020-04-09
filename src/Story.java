import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Story extends Task {
    private String summary;
    private List<SubTrack> subTracks = new LinkedList<>();
    private StoryStatus status;

    public Story(String title, String creator, String assignee, LocalDate dueDate,
            String summary) {
        super(TicketGenerator.generate(), title, creator, assignee, dueDate);
        this.summary = summary;
        this.status = StoryStatus.OPEN;
    }

    public String getSummary() {
        return summary;
    }

    public List<SubTrack> getSubTracks() {
        return subTracks;
    }

    public void addSubTrack(SubTrack subTrack){
        subTracks.add(subTrack);
    }

    public StoryStatus getStatus() {
        return status;
    }

    public void setStatus(StoryStatus status) {
        this.status = status;
    }
}
