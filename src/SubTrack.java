import java.util.Objects;

public class SubTrack {
    private String ticket;
    private String title;
    private SubTrackStatus status;

    public SubTrack(String title) {
        this.ticket = TicketGenerator.generate();
        this.title = title;
        this.status = SubTrackStatus.OPEN;
    }

    public String getTicket() {
        return ticket;
    }

    public String getTitle() {
        return title;
    }

    public SubTrackStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SubTrack subTrack = (SubTrack) o;
        return Objects.equals(ticket, subTrack.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }
}
