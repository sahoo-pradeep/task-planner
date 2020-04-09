public class TicketGenerator {
    private static int count = 1;
    private static final String TEAM = "FK";
    private static final String SEPARATOR = "-";

    public synchronized static String generate(){
        return TEAM + SEPARATOR + count++;
    }
}
